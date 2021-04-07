package MapTest;

import Constant.OpticalConsts;

import java.util.HashMap;
import java.util.Map;

/**
 * @title: MapConpareTest
 * @Author Chen Lun
 * @Date: 2021/4/7
 */
public class MapCompareTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("type", OpticalConsts.PUSH_RECORD_NOTICE_TYPE.SITE_SHARING_FROM.value());
        System.out.println(map.get("type"));
        System.out.println(OpticalConsts.PUSH_RECORD_NOTICE_TYPE.SITE_SHARING_FROM.value());
        if (OpticalConsts.PUSH_RECORD_NOTICE_TYPE.SITE_SHARING_FROM.value().equals((String) map.get("type"))) {
            System.out.println(1);
        }
        if (map.get("type").equals(OpticalConsts.PUSH_RECORD_NOTICE_TYPE.SITE_SHARING_FROM.value())) {
            System.out.println(2);
        }
    }
}
