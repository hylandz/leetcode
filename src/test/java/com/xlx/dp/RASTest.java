package com.xlx.dp;

import com.xlx.leetcode.other.crypto.RSACoder;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * RSA测试
 *
 * @author xielx at 2020/3/16 20:46
 */
public class RASTest {
    
    private String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD2g+p4SEx2l+Qg0hWvT6qh3MrtnEHcy2VnSpPn/xF3iStp6G+z8gyvtgTdImRMV2YNzrV4HrYuX5uFfp89Xtu5jaxPILUHplauWhNjatMvmi2LAKVXv";
    private String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAPaD6nhITHaX5CDSFa9PqqHcyu2cQdzLZWdKk+f/EXeJK2nob7PyDK+2BN0iZExXZg3OtXgeti5fm4V+nz1e27mNrE8gtQemVq5aE2Nq0y+aLYsApVe9o0KICqoiKdcluc6x3WFlQfF5YpHymbRSFLDynAyXt6Rzg9TVjcXmYb4jAgMBAAECgYAtDwGtiLGJP8wv/5Z9G9e5jEz/T39uZzMaxTPxxNqhec4Ypqa8QnL1LxUGgoHIvnTl8zGSSjLMmScpKHLc2djZXugrwXSy0rHI15b5gLL1N4ODssKEQ+dZ3E8efLcOpHTUbtXIjvetmXMZpipkaQHgqSCZ8ycvt55t8PS4QsGJWQJBAP1Ap71oFIMDn6j8l+yPTxzV4SfjaIsp1c0TGZg1DtAXv76gfFL2Ft8+M+IK9ESQWXkm4ooPmgfzB/U3dK2ccr0CQQD5MIy0LdlxJMc9zEB2U6Z6uDY/HmetJohetcS60cUITbta4ZysOYF2SdQGgzKc3Z1FahI68CX4oXUers8QV3JfAkEAihL9ISwkusV3//cvkX8UwADwEAJRVkZJ1dRLCQwsdlHsba8r+UNIdxB/0wbr5JHa5k3IB0O4VAsx1IUWrSz19QJAE0n3yka2SzTOm3EBGGe3Pk6eHFqtKdEOw04MsW1ldBQYSZunNgmphM+IMwza0RuyfdoNGTTXq5xL5ZkgfCJYvwJABqNqQo/vuCSWJABnBGJPUoLxiOgdl/7rBVqaa2jKZn4vGH+j2KfkDZcJ3iZxjfVJf46wvu1YYZHXEPlWkxGZ/w==";
    
    //@Before
    public void init() throws Exception{
        System.out.println("-------------创建密钥对");
        Map<String,Object> map = RSACoder.initKey();
        publicKey = RSACoder.getPublicKey(map);
        privateKey = RSACoder.getPrivateKey(map);
        System.out.println("公钥:\n\r" + publicKey);
        System.out.println("私钥:\n\r" + privateKey);
    }
    
    @Test
    public void testRSA() throws Exception{
        String data = "i do love you";
        System.out.println("数据加密前:\n\r" + data);
        // 私钥加密数据
        byte[] encryptData = RSACoder.encryptByPrivateKey(data.getBytes(), privateKey);
        System.out.println("加密数据:\n\r" + new String(encryptData));
        // 私钥数据签名
        String sign = RSACoder.sign(encryptData, privateKey);
        System.out.println("私钥签名:\n\r" + sign);
        // 乙方收到数据先校验加密数据
        boolean verify = RSACoder.verify(encryptData, publicKey+"1235ddfdfdf", sign);
        System.out.println("校验签名:\n\r" + verify);
        // 签名合法,公钥解密数据
        byte[] decryptData = RSACoder.decryptByPublicKey(encryptData, publicKey);
        System.out.println("解密数据:\n\r" + new String(decryptData));
        System.out.println("-----------------乙方发送数据");
        // 乙方加密信息
        String data2 = "me too";
        System.out.println("乙方发送数据:\n\r" + data2);
        byte[] encryptData2 = RSACoder.encryptByPublicKey(data2.getBytes(), publicKey);
        System.out.println("乙方加密数据:\n\r" + new String(encryptData2));
        // 甲方解密
        byte[] decryptData2 = RSACoder.decryptByPrivateKey(encryptData2, privateKey);
        System.out.println("解密乙方加密数据:\n\r" + new String(decryptData2));
    
    }
}
