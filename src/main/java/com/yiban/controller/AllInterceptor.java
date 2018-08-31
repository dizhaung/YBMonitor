package com.yiban.controller;

import cn.yiban.open.Authorize;
import com.yiban.service.Md5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.yiban.entity.AppContent.*;

/**
 * 拦截器，拦截所有路径，如果session中找不到yiban_id就需要进行授权，除李鑫以外的所有账号都不能登入
 * Created by Kuexun on 2018/6/23.
 */
@Component
public class AllInterceptor implements HandlerInterceptor {

    @Autowired
    private Md5Utils md5Utils;
    private Logger logger = LoggerFactory.getLogger(AllInterceptor.class);

    /**
     * 登录拦截器，没授权就拦截（https://openapi.yiban.cn/oauth/authorize）
     * @param request 获取session
     * @param response 用于重定向
     * @param o 不知道有啥用
     * @return true就放行，false就拦截
     * @throws Exception 不处理异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
