package com.xlx.leetcode.other.crypto;

import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;

/**
 * @author xielx at 2020/3/16 16:56
 */
public class Coder {
    
    /**
     * BASE64编码
     * @param src 待编码字符
     * @return 已编码字符
     */
    protected static String encryptBASE64ToString(String src){
        return new String (Base64Utils.encode(src.getBytes()), StandardCharsets.UTF_8);
    }
    
    protected static String encryptBASE64(byte[] src){
        return new String (Base64Utils.encode(src), StandardCharsets.UTF_8);
    }
    
    /**
     * Base64解码
     * @param decode 已编码字符
     * @return 解码的字符
     */
    protected static String decryptBASE64ToString(String decode){
        return new String(Base64Utils.decode(decode.getBytes()), StandardCharsets.UTF_8);
    }
    
    protected static byte[] decryptBASE64(String decode){
        return Base64Utils.decode(decode.getBytes());
    }
}
