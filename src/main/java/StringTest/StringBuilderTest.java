package StringTest;

import Domain.Cat;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: StringBuilderTest
 * Author: ChenLun
 * date: 2021/9/24
 * Description:
 */
@Slf4j
public class StringBuilderTest {
    public static void main(String[] args) throws IllegalAccessException {
//        StringBuilder sb = new StringBuilder(null);
//        System.out.println(sb.indexOf("/"));

        StringBuilder sb = new StringBuilder();

        Cat cat = new Cat(null, 1);

        Map<String, String> fieldValueMap = new HashMap<>();

        Class<?> objClass = cat.getClass();
        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(Boolean.TRUE);
            fieldValueMap.put(field.getName(), String.valueOf(field.get(cat)));
        }
        log.info("field: " + fieldValueMap);

        sb.append(cat.getName());
        sb.append(cat.getName());
        sb.append(cat.getName());

        log.info(sb.toString());

        sb.append("City");
        sb.append("Distinct");
        log.info(sb.toString());

        sb.insert(0, "Province");
        log.info(sb.toString());
    }
}
