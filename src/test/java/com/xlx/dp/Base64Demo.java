package com.xlx.dp;

import org.springframework.util.Base64Utils;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * Base64
 *
 * @author xielx at 2020/3/13 21:19
 */
public class Base64Demo {
    
    // Base64编码
    static String base64Encode(String src) throws UnsupportedEncodingException {
        return new String (Base64Utils.encode(src.getBytes()), StandardCharsets.UTF_8);
    }
    
    // Base64解码
    static String base64Decode(String decode) throws UnsupportedEncodingException {
        return new String(Base64Utils.decode(decode.getBytes()), StandardCharsets.UTF_8);
    }
    
    public static void main(String[] args) throws UnsupportedEncodingException {
        String src = "";
        String encode = base64Encode(src);
        System.out.println(encode);
        System.out.println(base64Decode(encode));
    
    }
}
