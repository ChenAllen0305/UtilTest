package ObjectTest;

import com.alibaba.fastjson.JSON;

/**
 * @className: ObjectToStringTest
 * @author: ChenLun
 * @date: 2022/10/11 10:05
 * @description:
 */
public class ObjectToStringTest {

    public static void main(String[] args) {
        String str = JSON.toJSONString(null);
        System.out.println("str : " + str);
    }
}
