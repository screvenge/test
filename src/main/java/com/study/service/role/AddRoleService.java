package com.study.service.role;

import com.study.common.BaseException;
import com.study.common.BaseRsp;
import com.study.common.IService;
import com.study.dao.role.RoleDao;
import com.study.message.role.req.AddRoleReq;
import com.study.model.role.Role;
import com.study.service.cache.ResourceCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 添加角色服务类
 */
@Service("addRoleService")
public class AddRoleService implements IService<AddRoleReq, BaseRsp> {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private ResourceCache resourceCache;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public BaseRsp doExcute(AddRoleReq req) throws Exception {

        //将请求数据赋值给java模型类Role
        Role role = new Role();
        role.setDesc(req.getDesc());

        //查询此角色是否存在
        if(roleDao.selectAllRoleNames().contains(req.getDesc())){//已存在此角色
            throw new BaseException(9999);
        }

        //新增角色
        roleDao.addRole(role);

        //刷新本地缓存
        resourceCache.getResourceCache().refresh(role.getId());

        return new BaseRsp();
    }
}