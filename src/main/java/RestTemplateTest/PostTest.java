package RestTemplateTest;

import RestTemplateTest.body.ResToken;
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
public class PostTest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://10.0.40.70:12000/uni/oauth/token?grant_type=client_credentials&client_id=1648086844872&client_secret=c0e5770c724396c056d63a2689e70c1c";

        HttpHeaders headers = new HttpHeaders();
        headers.set("userId", "test user id");
        headers.set("companyId", "test company id");

        HttpEntity httpEntity = new HttpEntity<>(null, headers);

        ResponseEntity<ResToken> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, ResToken.class);

        ResToken user = responseEntity.getBody();
        System.out.println(user.getToken_type() + user.getAccess_token());
    }
}

