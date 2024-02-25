package com.xiaofei.management.common.exception.file;

import com.xiaofei.management.common.exception.base.BaseException;

/**
 * 文件信息异常类
 * 
 * @author xiaofei
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
