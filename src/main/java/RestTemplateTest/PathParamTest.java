package RestTemplateTest;

import RestTemplateTest.body.ResponseBody;
import RestTemplateTest.body.User;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: LocalTest2
 * @author: ChenLun
 * @date: 2022/3/29 15:35
 * @description:
 */
public class PathParamTest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:13000/user/byId?id={id}";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", "de84e453-c04d-4a8c-a8c7-2983489d85a0");

        ResponseBody<User> responst = restTemplate.getForObject(url, ResponseBody.class, paramMap);
        System.out.println(responst.getData());
    }
}
