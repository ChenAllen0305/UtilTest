

import cn.hutool.crypto.SecureUtil;

import java.security.KeyPair;
import java.util.Base64;

/**
 * @author wangjp
 * @date 2023/8/24 15:31
 * @description 密钥对生成
 */
public class SM2KeyPair {

    private void gen() {
        KeyPair pair = SecureUtil.generateKeyPair("SM2");
        byte[] privateKey = pair.getPrivate().getEncoded();
        byte[] publicKey = pair.getPublic().getEncoded();
        System.out.println("私钥：" + Base64.getEncoder().encodeToString(privateKey));
        System.out.println("公钥：" + Base64.getEncoder().encodeToString(publicKey));
    }

    public static void main(String[] args) {
        SM2KeyPair sm2KeyPair = new SM2KeyPair();
        sm2KeyPair.gen();
    }
}
