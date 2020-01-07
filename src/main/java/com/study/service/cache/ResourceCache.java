package com.study.service.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.study.dao.role.RoleDao;
import com.study.message.role.data.ResourceRoleRelationInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 资源本地缓存
 */
@Service
public class ResourceCache {
    @Autowired
    private RoleDao roleDao;

    public LoadingCache<String, Long> getRoleIdCache() {
        return CacheBuilder.newBuilder().maximumSize(3000).expireAfterWrite(86400, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Long>() {
                    @Override
                    public Long load(String account) throws Exception {
                        //在这里可以初始化加载数据的缓存信息，读取数据库中信息或者是加载文件中的某些数据信息
                        List<ResourceRoleRelationInfo> relationInfos = roleDao.queryResourceByAccount(account);

                        // 约定-1位角色不存在
                        Long roleId = -1L;
                        if (CollectionUtils.isNotEmpty(relationInfos)) {
                            // 直接手动添加资源的本地缓存不再查数据库了
                            roleId = relationInfos.get(0).getRoleId();
                            getResourceCache().put(roleId, relationInfos.stream()
                                    .map(ResourceRoleRelationInfo::getName).collect(Collectors.toList()));
                        }

                        return roleId;
                    }
                });
    }

    public LoadingCache<Long, List<String>> getResourceCache() {
        // maximumSize 定义对象个数的限制，如果没有定义过期规则则超出限制的时候，会将最远时间最少使用的自动过期保证总数在设置的范围内
        // expireAfterWrite 超时时间
        return CacheBuilder.newBuilder().maximumSize(3000).expireAfterWrite(86400, TimeUnit.SECONDS)
                .build(new CacheLoader<Long, List<String>>() {
                    @Override
                    public List<String> load(Long roleId) throws Exception {
                        //在这里可以初始化加载数据的缓存信息，读取数据库中信息或者是加载文件中的某些数据信息
                        return roleDao.queryResourceByRoleId(roleId);
                    }
                });
    }
}
