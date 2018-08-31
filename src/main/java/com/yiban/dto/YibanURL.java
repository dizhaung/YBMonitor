package com.yiban.dto;

/**
 * 统一管理URL,将需要调用的易班接口统一在这个类中管理
 */
public class YibanURL {
    //获取access_token
    public static final String Access_Token = "https://openapi.yiban.cn/oauth/access_token";
    //消息发送URL
    public static final String SendLetter = "https://openapi.yiban.cn/msg/letter";
    //用户个人信息
    public static final String Me = "https://openapi.yiban.cn/user/me";
}
