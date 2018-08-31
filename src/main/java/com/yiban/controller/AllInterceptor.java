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
 * ����������������·�������session���Ҳ���yiban_id����Ҫ������Ȩ������������������˺Ŷ����ܵ���
 * Created by Kuexun on 2018/6/23.
 */
@Component
public class AllInterceptor implements HandlerInterceptor {

    @Autowired
    private Md5Utils md5Utils;
    private Logger logger = LoggerFactory.getLogger(AllInterceptor.class);

    /**
     * ��¼��������û��Ȩ�����أ�https://openapi.yiban.cn/oauth/authorize��
     * @param request ��ȡsession
     * @param response �����ض���
     * @param o ��֪����ɶ��
     * @return true�ͷ��У�false������
     * @throws Exception �������쳣
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
