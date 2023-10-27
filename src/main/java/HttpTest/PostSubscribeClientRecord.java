package HttpTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: PostSubscribeRecord
 * @author: ChenLun
 * @date: 2022/7/20 9:27
 * @description:
 */
@Slf4j
public class PostSubscribeClientRecord {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String tenantCode = "b86654f4-3690-490d-bdf0-a4507661bbdb";

        HttpHeaders headerWithTokenAndTenantCode = new HttpHeaders();
        headerWithTokenAndTenantCode.set("Authorization",
                "bearer" +
                        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNjU4MzAxNTM3LCJhdXRob3JpdGllcyI6WyJ3cml0ZSIsInJlYWQiXSwianRpIjoiYjc4NjkyYTctMmM5OC00N2IwLTg4MjQtNDU4MjVkYzc0NzBlIiwiY2xpZW50X2lkIjoiMTY1MjY3MzM2MTM5MCJ9.-xAxCFS4SVYJJlDk5e45IHv0Tz6qyNwfLsBUcf5LVuw"
        );
        headerWithTokenAndTenantCode.set("tenantCode", tenantCode);
        headerWithTokenAndTenantCode.setContentType(MediaType.parseMediaType("application/json;charset=UTF-8"));

        String subscribeUrl = "http://10.7.1.45:14502/openapi/unicloud-id-parse-center-cl/api/v1/tenant/subscribe";

        Map<String, Object> tenantSubscribeVO = new HashMap<>(8);
        tenantSubscribeVO.put("tenantCode", tenantCode);
        tenantSubscribeVO.put("topic", "LocalTopic3");
        tenantSubscribeVO.put("clientId", "1652673361390");
        tenantSubscribeVO.put("subscribeData", "LocalSubscribeData3");
        tenantSubscribeVO.put("type", "1");
        tenantSubscribeVO.put("project", "LocalTest");
        tenantSubscribeVO.put("consumerGroup", "LocalConsumerGroup");
        tenantSubscribeVO.put("subscribeTime", new Date());

        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(tenantSubscribeVO, headerWithTokenAndTenantCode);

        try {
            ResponseEntity<ResponseString> responseString = restTemplate
                    .exchange(subscribeUrl, HttpMethod.POST, httpEntity, ResponseString.class, tenantSubscribeVO);
            if (responseString.getBody() == null) {
                log.error("订阅失败，平台订阅服务响应为空");
            }
            log.error("responseString.getBody().getCode() == 200 : " + (responseString.getBody().getCode() == 200));
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error(String.format("订阅失败，原因: %s", e.getMessage()));
        }
    }
}
