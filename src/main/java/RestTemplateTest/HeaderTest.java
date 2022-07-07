package RestTemplateTest;

import RestTemplateTest.body.ResponseUser;
import RestTemplateTest.body.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @className: HeaderTest
 * @author: ChenLun
 * @date: 2022/3/29 15:31
 * @description:
 */
public class HeaderTest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:13000/user/fd8adf8c-8c2c-461d-b9c6-77519e029506";

        HttpHeaders headers = new HttpHeaders();
        headers.set("userId", "test user id");
        headers.set("companyId", "test company id");

        HttpEntity<ResponseUser> httpEntity = new HttpEntity<>(null, headers);

        ResponseEntity<ResponseUser> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, ResponseUser.class);

        ResponseUser user = responseEntity.getBody();
        User user1 = user.getData();
        System.out.println(user);
    }
}

