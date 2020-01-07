package com.study.interceptor;

import com.study.common.AccountUtil;
import com.study.message.role.data.ResourceInfo;
import com.study.service.cache.ResourceCache;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 鉴权拦截器
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    private ResourceCache resourceCache;

    /**
     * 前置拦截
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理器
     * @return 是否通过拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取servlet路径 形如api/xxx格式
        String path = request.getServletPath();

        // 从cookie中获取账号信息并把它赋予给公共的账号
        Cookie[] cookies = request.getCookies();
        String account = null;
        if (ArrayUtils.isNotEmpty(cookies)) {
            for (Cookie cookie : cookies) {
                // 通过解密算法解密获取当前人账号, 面试时可以说HmacSha256
                if (cookie.getName().equals("account")) {
                    AccountUtil.getInstance().setAccount(cookie.getValue());
                    account = cookie.getValue();
                    break;
                }
            }
        }

        // 鉴权失败
        if (StringUtils.isBlank(account)) {
        	return false;
        }

        // 查看该账号是否包含请求的servletPath, getResourceCache()返回一个loadingcache
        List<ResourceInfo> resourceInfos = resourceCache.getResourceCache().get(account);
        if (CollectionUtils.isEmpty(resourceInfos) || resourceInfos.stream().map(ResourceInfo::getName)
                .noneMatch(resourceName -> path.equals(resourceName))) {
        	return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
