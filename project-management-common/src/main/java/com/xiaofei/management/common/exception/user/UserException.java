package com.xiaofei.management.common.exception.user;

import com.xiaofei.management.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author xiaofei
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
