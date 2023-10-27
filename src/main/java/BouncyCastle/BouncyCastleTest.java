package BouncyCastle;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * @className: BouncyCastleTest
 * @author: ChenLun
 * @date: 2022/10/12 10:36
 * @description:
 */
public class BouncyCastleTest {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 注册BouncyCastle:
        Security.addProvider(new BouncyCastleProvider());
        // 按名称正常调用:
        MessageDigest md = MessageDigest.getInstance("RipeMD160");
        md.update("HelloWorld".getBytes("UTF-8"));
        byte[] result = md.digest();
        System.out.println(new BigInteger(1, result).toString(16));

        byte[] digestResult = md.digest(result);
        System.out.println(new BigInteger(1, digestResult).toString(16));
    }
}
