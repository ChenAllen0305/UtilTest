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
public class PostSubscribeRecord {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String tenantCode = "b86654f4-3690-490d-bdf0-a4507661bbdb";

        HttpHeaders headerWithTokenAndTenantCode = new HttpHeaders();
        headerWithTokenAndTenantCode.set("Authorization", "bearereyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTgyODIyNTEsInVzZXJfbmFtZSI6InpneU1lcyIsImF1dGhvcml0aWVzIjpbIndyaXRlIiwicmVhZCJdLCJqdGkiOiJmZGQ5YjljYi1jNTE1LTQwZDktYjAzYi1mZmFmNDE2Yzg0NjMiLCJjbGllbnRfaWQiOiJKOEtxMTY5aDU2dG0iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.ChSRtsuDIvOI8jZi2MWbJ-McmKMze60v_bguFNth07s");
        headerWithTokenAndTenantCode.set("tenantCode", tenantCode);
        headerWithTokenAndTenantCode.setContentType(MediaType.parseMediaType("application/json;charset=UTF-8"));

        String subscribeUrl = "http://localhost:9200/api/v1/tenant/subscribe";

        Map<String, Object> tenantSubscribeVO = new HashMap<>(8);
        tenantSubscribeVO.put("tenantCode", tenantCode);
        tenantSubscribeVO.put("topic", "LocalTopic");
        tenantSubscribeVO.put("clientId", "1652673361390");
        tenantSubscribeVO.put("subscribeData", "LocalSubscribeData");
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
