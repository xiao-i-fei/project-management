package com.xiaofei.management.common.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

/**
 * 参数请求加密工具
 * ClassName: EncryptionUtils
 * Package: com.xiaofeio.api.autoconfigure.utils
 *
 * @Author: XiaoFei
 * @Create: 2024/3/2 18:40
 * @Email: 1903078434@qq.com
 * @Version: 1.0
 */
public class EncryptionUtils {

    private static SymmetricCrypto buildSymmetricCrypto(String secretKey) {

        // 根据secretKey生成秘钥
        byte[] key = secretKey.getBytes();

        // 构建
        return new SymmetricCrypto(SymmetricAlgorithm.AES, key);
    }

    /**
     * 加密数据
     */
    public static String encrypt(String data, String secretKey) {
        SymmetricCrypto aes = buildSymmetricCrypto(secretKey);
        //加密
        byte[] encrypt = aes.encrypt(data);
        //加密为16进制表示
        return aes.encryptHex(data);
    }

    /**
     * 解密数据
     */
    public static String decrypt(String encryptedData, String secretKey) {
        SymmetricCrypto aes = buildSymmetricCrypto(secretKey);
        return aes.decryptStr(encryptedData, CharsetUtil.CHARSET_UTF_8);
    }

}
