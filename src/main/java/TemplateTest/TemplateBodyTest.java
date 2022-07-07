package TemplateTest;

import feign.Request;
import feign.RequestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: TemplateBodyTest
 * Author: ChenLun
 * date: 2021/8/17
 * Description:
 */
public class TemplateBodyTest {
    public static void main(String[] args) {
        RequestTemplate template = new RequestTemplate();
        Map<String, String> bodyNames = new HashMap<>();


        StringBuilder body = new StringBuilder();
        Map<String, Object> map = new HashMap<>();
        if (bodyNames != null) {
            for (Map.Entry<String, String> entry : bodyNames.entrySet()) {
                String name = entry.getKey();
                String values = entry.getValue();
                body.append(name).append("=").append(values).append("&");
                map.put(name, values);
            }
        }
        if (body.length() != 0) {
            body.deleteCharAt(body.length() - 1);
            Request.Body body1 = template.requestBody();
//            body1 = body1.expand(map);
//            template.body(body1);
        }
    }
}
