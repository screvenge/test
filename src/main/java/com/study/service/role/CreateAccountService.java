package com.study.service.role;

import com.study.common.BaseException;
import com.study.common.BaseRsp;
import com.study.common.IService;
import com.study.common.constants.Constants;
import com.study.common.constants.DepId;
import com.study.common.constants.RoleId;
import com.study.dao.role.RoleDao;
import com.study.dao.staff.StaffDao;
import com.study.message.role.req.CreateAccountReq;
import com.study.model.role.Account;
import com.study.model.staff.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("createAccountService")
public class CreateAccountService implements IService<CreateAccountReq, BaseRsp> {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private StaffDao staffDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public BaseRsp doExcute(CreateAccountReq req) throws Exception {

        //找到对应账号的员工信息
        Staff staff = staffDao.selectStaffByJobNumber(req.getJobNumber());

        if (staff == null) {
            throw new BaseException(9999);
        }

        //将数据赋值到account模型中
        Account account = setAccountData(staff.getDepartmentId(), req);

        //插入account表
        roleDao.addAccount(account);

        return new BaseRsp();
    }

    private Account setAccountData(Long departmentId, CreateAccountReq req) {

        Account account = new Account();

        if (departmentId == DepId.FCM) {
            account.setRoleId(RoleId.FCMSTAFF);
        }

        if (departmentId == DepId.BOSS) {
            account.setRoleId(RoleId.MANAGER);
        } else {
            account.setRoleId(RoleId.COMMONSTAFF);
        }

        account.setAccount(req.getJobNumber());
        account.setAccountName(req.getName());

        return account;
    }
}
