package com.study.service.role;

import com.study.common.BaseRsp;
import com.study.common.IService;
import com.study.dao.role.RoleDao;
import com.study.message.role.req.AddResourceReq;
import com.study.model.role.Resource;
import com.study.service.cache.ResourceCache;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 添加资源服务类
 */
@Service("addResourceService")
public class AddResourceService implements IService<AddResourceReq, BaseRsp> {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private ResourceCache resourceCache;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public BaseRsp doExcute(AddResourceReq req) throws Exception {
        Resource resource = new Resource();
        //将req中的对应数据赋值到java模型中
        BeanUtils.copyProperties(req, resource);

        //若父级资源不为空,查询parentResourceId
        Long parentResourceId = null;
        if (StringUtils.isNotBlank(req.getParentResourceName())) {
            parentResourceId = roleDao.selectRoleId(req.getParentResourceName());
        }
        resource.setParentResourceId(parentResourceId);

        //根据角色名查询角色id
        Long roleId = roleDao.selectRoleId(req.getRole());

        //向资源表插入数据
        roleDao.addResource(resource);

        //向关联表中插入数据
        roleDao.addRelationShip(roleId, resource.getId());

        //刷新本地缓存
        resourceCache.getResourceCache().refresh(roleId);

        return new BaseRsp();
    }


}
