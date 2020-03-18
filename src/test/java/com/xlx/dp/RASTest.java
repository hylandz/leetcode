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
    
    private String publicKey;
    private String privateKey;
    @Before
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
