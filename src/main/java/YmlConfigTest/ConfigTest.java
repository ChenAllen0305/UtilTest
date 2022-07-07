package YmlConfigTest;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ConfigTest
 * Author: ChenLun
 * date: 2021/9/26
 * Description:
 */
@Slf4j
public class ConfigTest {

    private final ThresholdConfig thresholdConfig;

    public ConfigTest(ThresholdConfig thresholdConfig) {
        this.thresholdConfig = thresholdConfig;
    }

    public void main(String[] args) {
        getMap().forEach((key, value) -> log.info(key + ":" + value));
    }
    
    private Map<String, ThresholdEntity> getMap() {
        Map<String, ThresholdEntity> map = new HashMap<>();
        List<ThresholdEntity> entities = thresholdConfig.getThreshold();
        entities.forEach(k -> map.put(k.getCode(), k));
        return map;
    }
}
