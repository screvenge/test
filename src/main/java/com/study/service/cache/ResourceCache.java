package com.study.service.cache;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.study.dao.role.RoleDao;
import com.study.message.role.data.ResourceInfo;

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
                        return roleDao.queryRoleIdByAccount(account);
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
                        return roleDao.queryResourceByAccount(roleId);
                    }
                });
    }
}
