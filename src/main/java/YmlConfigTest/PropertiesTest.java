package YmlConfigTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

/**
 * @className: YmlConfigTest.PropertiesTest
 * @author: ChenLun
 * @date: 2023/1/9 15:47
 * @description:
 */
@Slf4j
public class PropertiesTest {

    @Value("${bizModel.name}")
    private static String bizModel;

    @Value("${unicloud-ps.name}")
    private static String ps;

    public static void main(String[] args) {
        log.info("bizModel : " + bizModel);
        log.info("ps : " + ps);
    }
}
