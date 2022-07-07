package Test;

import Util.AesUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @className: AesTest
 * @author: ChenLun
 * @date: 2022/6/23 16:52
 * @description:
 */
@Slf4j
public class AesTest {
    public static void main(String[] args) {

        String password = "password";

        String cypher = AesUtil.aesEncrypt(password);
        log.info("cypher: " + cypher);

        String dcypher = AesUtil.aesDecrypt(cypher);
        log.info("dcypher: " + dcypher);
    }
}
