package RestTemplateTest;

import org.springframework.web.client.RestTemplate;

/**
 * @className: DeleteTest
 * @author: ChenLun
 * @date: 2022/3/29 16:24
 * @description:
 */
public class DeleteTest {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:13000/user/release/de84e453";

        restTemplate.delete(url);
    }
}
