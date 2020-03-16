package com.xlx.leetcode.other.crypto;

import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * rsa加解密
 * 流程:
 *  甲方
 *   1. 创建密钥对,公钥给乙方,私钥保留
 *   2. 私钥加密数据.私钥对加密的数据签名
 *   3. 私钥解密乙方发送的加密数据
 *  乙方
 *   1. 获取公钥
 *   2. 获取甲方发送的加密数据和签名
 *   3. 公钥验证加密数据是否有效(校验签名)
 *   4. 公钥解密加密的数据
 *   5. 公钥加密信息,发送给甲方
 * @author xielx at 2020/3/16 16:50
 */
public abstract class RSACoder extends Coder {
    
    
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    
    
    /**
     * 创建密钥对
     * @return
     * @throws Exception
     */
    public static Map<String,Object> initKey() throws Exception{
        KeyPairGenerator generator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        generator.initialize(1024);
        KeyPair keyPair = generator.generateKeyPair();
        // 获取公钥,私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        
        Map<String,Object> keyMap = new HashMap<>(2);
        keyMap.put(PUBLIC_KEY,publicKey);
        keyMap.put(PRIVATE_KEY,privateKey);
        
        return keyMap;
    }
    
    /**
     * 获取公钥
     * @param keyMap 密钥对
     * @return
     */
    public static String getPublicKey(Map<String,Object> keyMap){
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return encryptBASE64(key.getEncoded());
    }
    
    /**
     * 获取私钥
     * @param keyMap 密钥对
     * @return
     */
    public static String getPrivateKey(Map<String,Object> keyMap){
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return encryptBASE64(key.getEncoded());
    }
    
    /**
     * 公钥加密数据
     * @param data 数据
     * @param key 公钥
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data,String key) throws Exception{
        byte[] bytes = decryptBASE64(key);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        
        // 数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        return cipher.doFinal(data);
    }
    
    /**
     * 私钥加密数据
     * @param data 数据
     * @param key 私钥
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data,String key) throws Exception{
        // 解码私钥
        byte[] priKey = decryptBASE64(key);
        PKCS8EncodedKeySpec  pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec (priKey);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        
        // 数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE,privateKey);
        return cipher.doFinal(data);
    }
    
    /**
     * 公钥解密数据
     * @param data 加密数据
     * @param key 公钥
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data,String key) throws Exception{
        // 解码公钥
        byte[] pubKey = decryptBASE64(key);
        // 获取公钥
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(pubKey);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        
        // 数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE,publicKey);
       
        return cipher.doFinal(data);
    }
    
    /**
     * 私钥解密数据
     * @param data 加密数据
     * @param key 私钥
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data,String key) throws Exception{
        // 解码私钥
        byte[] priKey = decryptBASE64(key);
        // 获取私钥
        PKCS8EncodedKeySpec  pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec (priKey);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        
        // 数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        
        return cipher.doFinal(data);
    }
    
    
    
    /**
     * 用私钥对信息生成数字签名
     * @param data 加密数据
     * @param privateKey 私钥
     * @return 签名
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey)throws Exception{
        // 私钥解码
        byte[] keyBytes = decryptBASE64(privateKey);
    
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 获取私钥对象
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        // 用私钥对信息进行签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(priKey);
        signature.update(data);
        
        return encryptBASE64(signature.sign());
    }
    
    /**
     * 检验签名
     * 乙方使用公钥和签名对加密数据校验是否有效
     * @param data 加密的数据
     * @param publicKey 公钥
     * @param sign 签名
     * @return true:有效
     */
    public static boolean verify(byte[] data,String publicKey,String sign) throws Exception{
        // 解码的公钥
        byte[] keyBytes = decryptBASE64(publicKey);
        // 创建X509EncodedKeySpec对象
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        // 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 获取公钥
        PublicKey pubKey = keyFactory.generatePublic(x509EncodedKeySpec);
        
        // 校验签名
        final Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(data);
    
        return signature.verify(decryptBASE64(sign));
    }
}
