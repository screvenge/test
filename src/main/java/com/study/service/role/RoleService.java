package com.study.service.role;

import com.study.common.BaseException;
import com.study.dao.role.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleService extends BaseException {

    @Autowired
    private RoleDao roleDao;

    public void checkAuthority(Long jobNumber, String serviceName) throws BaseException {
        List<String> resources = roleDao.selectResource(jobNumber);

        if (!resources.contains(serviceName)) {
            throw new BaseException(9999);
        }
    }

}
