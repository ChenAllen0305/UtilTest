import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @className: WhiteList
 * @author: ChenLun
 * @date: 2023/6/27 17:31
 * @description:
 */
@Slf4j
public class WhiteList {
    public static void main(String[] args) throws MalformedURLException {
        List<String> redirectUriWhiteList = Arrays.asList("10.0.40.*", "10.0.40.189", "10.0.40.190", "58.223.177.123", "10.0.0.*", "10.0.0.38", "10.0.53.*", "10.0.50.*");

        String redirectUri = "http://10.0.50.26:8081/";
        URL redirectUrl = new URL(redirectUri);
        String redirectUrlHost = redirectUrl.getHost();

        String localAddr = "10.0.53.166";

        if (redirectUriWhiteList.stream().noneMatch(uri -> checkIP(uri, localAddr, redirectUrlHost))) {
            log.info("uri错误 redirectUri: {}, redirectUriWhiteList: {}, localAddr: {}", redirectUri, redirectUriWhiteList.toString(), localAddr);

        }
    }

    private static boolean checkIP(String whiteIp, String localAddr, String redirectHost) {
        if (StringUtils.isEmpty(whiteIp) || Objects.equals(whiteIp, redirectHost) || Objects.equals(localAddr, redirectHost)) {
            return true;
        }
        if (!whiteIp.contains("*")) {
            return false;
        }
        String[] whiteIpSplit = whiteIp.split("\\.");
        String[] redirectHostSplit = redirectHost.split("\\.");
        int min = Math.min(whiteIpSplit.length, redirectHostSplit.length);
        // 10.*.*.1  10.7.1.47
        for (int i = 0; i < min; i++) {
            String whiteIpElement = whiteIpSplit[i];
            String redirectHostElement = redirectHostSplit[i];
            //如果不相等， 且不是* ，return false
            if (!Objects.equals("*", whiteIpElement) && !Objects.equals(whiteIpElement, redirectHostElement)) {
                return false;
            }
        }
        return true;
    }
}
