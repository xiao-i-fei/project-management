package com.xiaofei.management.common.exception.user;

/**
 * 验证码失效异常类
 * 
 * @author xiaofei
 */
public class CaptchaExpireException extends UserException
{
    private static final long serialVersionUID = 1L;

    public CaptchaExpireException()
    {
        super("user.jcaptcha.expire", null);
    }
}
