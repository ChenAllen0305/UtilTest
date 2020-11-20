package Test;

import Util.UUIDUtil;

import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args) {
//        UUIDTest uuidTest = new UUIDTest();
        // UUID为通用唯一识别码Universally Unique Identifier
        String uuid = UUIDUtil.getUUID();
        System.out.println(uuid);
        System.out.println(UUID.randomUUID());
    }
}