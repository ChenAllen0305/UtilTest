package ReadFile;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName: SimulatedDataConfig
 * Author: ChenLun
 * date: 2021/6/3
 * Description:
 */
@Component
@Data
//@ConfigurationProperties(prefix = "simulateddata")
public class SimulatedDataConfig {
    @Value("${simulatedData.productName}")
    private String productName;

    @Value("${simulatedData.equipmentName}")
    private String equipmentName;

    @Value("${simulatedData.equipmentId}")
    private String equipmentId;

    @Value("${simulatedData.area}")
    private String area;

    @Value("${simulatedData.energyRandomMin}")
    private Integer energyRandomMin;

    @Value("${simulatedData.energyRandomMax}")
    private Integer energyRandomMax;

    @Value("${simulatedData.amountRandomMin}")
    private Integer amountRandomMin;

    @Value("${simulatedData.amountRandomMax}")
    private Integer amountRandomMax;

    @Value("${simulatedData.powerTransformer}")
    private List<String> powerTransformer;

    @Value("${simulatedData.regulatingTransformer}")
    private List<String> regulatingTransformer;

    @Value("${simulatedData.audioFrequencyTransformer}")
    private List<String> audioFrequencyTransformer;

    @Value("${simulatedData.intermediateFrequencyTransformer}")
    private List<String> intermediateFrequencyTransformer;

    @Value("${simulatedData.highFrequencyTransformer}")
    private List<String> highFrequencyTransformer;
}
