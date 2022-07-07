package YmlConfigTest;

import lombok.Data;

/**
 * ClassName: ThresholdEntity
 * Author: ChenLun
 * date: 2021/9/26
 * Description:
 */
@Data
public class ThresholdEntity {
    private String code;

    private Integer min;

    private Integer max;
}
