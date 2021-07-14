package ReadFile;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName: WeChartConfig
 * Author: ChenLun
 * date: 2021/4/14
 * Description:
 */
@Component
@ConfigurationProperties(prefix = "wechat")
public class WeChartConfig {
    private String grant_type;
    private String appid;
    private String secret;

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
