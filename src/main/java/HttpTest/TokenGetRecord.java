package HttpTest;

import RestTemplateTest.body.ResToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @className: PostSubscribeRecord
 * @author: ChenLun
 * @date: 2022/7/20 9:27
 * @description:
 */
@Slf4j
public class TokenGetRecord {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://10.0.0.23:12000/uni/oauth/token?grant_type=client_credentials&client_id=1652673361390&client_secret=9dba7c3641e732661617e33c3ac980c5";

        HttpEntity<Object> urlHttpEntity = new HttpEntity<>(null, new HttpHeaders());
        try {
            ResponseEntity<ResToken> responseEntity = restTemplate.exchange(url, HttpMethod.POST, urlHttpEntity, ResToken.class);
            ResToken resToken = responseEntity.getBody();
            if (resToken == null) {
                log.info("获取开发者账号密钥失败，服务接口无响应");
            }
            String token = resToken.getToken_type() + resToken.getAccess_token();
            log.info("AccessToken: " + token);
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("获取开发者账号密钥失败");
        }

//        String tenantCode = "b86654f4-3690-490d-bdf0-a4507661bbdb";
//
//        HttpHeaders headerWithTokenAndTenantCode = new HttpHeaders();
//        headerWithTokenAndTenantCode.set("Authorization", "bearereyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTgyODIyNTEsInVzZXJfbmFtZSI6InpneU1lcyIsImF1dGhvcml0aWVzIjpbIndyaXRlIiwicmVhZCJdLCJqdGkiOiJmZGQ5YjljYi1jNTE1LTQwZDktYjAzYi1mZmFmNDE2Yzg0NjMiLCJjbGllbnRfaWQiOiJKOEtxMTY5aDU2dG0iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.ChSRtsuDIvOI8jZi2MWbJ-McmKMze60v_bguFNth07s");
//        headerWithTokenAndTenantCode.set("tenantCode", tenantCode);
//        headerWithTokenAndTenantCode.setContentType(MediaType.parseMediaType("application/json;charset=UTF-8"));
//
//        String subscribeUrl = "http://localhost:9200/api/v1/tenant/subscribe";
//
//        Map<String, Object> tenantSubscribeVO = new HashMap<>(8);
//        tenantSubscribeVO.put("tenantCode", tenantCode);
//        tenantSubscribeVO.put("topic", "LocalTopic");
//        tenantSubscribeVO.put("clientId", "1652673361390");
//        tenantSubscribeVO.put("subscribeData", "LocalSubscribeData");
//        tenantSubscribeVO.put("type", "1");
//        tenantSubscribeVO.put("project", "LocalTest");
//        tenantSubscribeVO.put("consumerGroup", "LocalConsumerGroup");
//        tenantSubscribeVO.put("subscribeTime", new Date());
//
//        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(tenantSubscribeVO, headerWithTokenAndTenantCode);
//
//        try {
//            ResponseEntity<ResponseString> responseString = restTemplate
//                    .exchange(subscribeUrl, HttpMethod.POST, httpEntity, ResponseString.class, tenantSubscribeVO);
//            if (responseString.getBody() == null) {
//                log.error("订阅失败，平台订阅服务响应为空");
//            }
//            log.error("responseString.getBody().getCode() == 200 : " + (responseString.getBody().getCode() == 200));
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            log.error(String.format("订阅失败，原因: %s", e.getMessage()));
//        }
    }
}
