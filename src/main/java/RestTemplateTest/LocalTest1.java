package RestTemplateTest;

import RestTemplateTest.body.ResponseBody;
import RestTemplateTest.body.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @className: LocalTest1
 * @author: ChenLun
 * @date: 2022/3/29 15:07
 * @description:
 */
public class LocalTest1 {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:13000/user/de84e453-c04d-4a8c-a8c7-2983489d85a0";

        // 需要和接口返回对象匹配
        User user = restTemplate.getForObject(url, User.class);
        String userStr = restTemplate.getForObject(url, String.class);

        System.out.println(user.getId() + " " + user.getName());
        System.out.println(userStr);


        ResponseEntity<User> responseEntity = restTemplate.getForEntity(url, User.class);
        User result = responseEntity.getBody();
        System.out.println(result.getId() + " " + result.getName());


        // 改用ResponseBody获取平台接口返回结果 - 成功
        ResponseBody<User> responst = restTemplate.getForObject(url, ResponseBody.class);
        System.out.println(responst.getData());

    }
}
