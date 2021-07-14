package ReadFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName: ReadFileTest
 * Author: ChenLun
 * date: 2021/4/14
 * Description:
 */
@Component
public class ReadFileTest {
    @Value("${weChat.grant_type}")
    private String grantType;
    private String appId;
    private String secret;
    @Autowired
    private static WeChartConfig config;
    @Autowired
    private static SimulatedDataConfig dataConfig;

    public static void main(String[] args) {
//        System.out.println(grantType);

        System.out.println(config.getAppid());
        System.out.println(config.getGrant_type());
        System.out.println(config.getSecret());
    }
}
