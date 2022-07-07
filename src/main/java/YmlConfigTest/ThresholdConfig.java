package YmlConfigTest;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName: ThresholdConfig
 * Author: ChenLun
 * date: 2021/9/26
 * Description:
 */
@Data
@Component
@ConfigurationProperties("tenant")
public class ThresholdConfig {

    private List<ThresholdEntity> threshold;
}
