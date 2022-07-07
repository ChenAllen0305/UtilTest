package Field.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: PriceInfoDO
 * @author: ChenLun
 * @date: 2022/4/21 18:01
 * @description: 推介厂商和价格详情
 */
@Data
public class PriceInfo {

    @ApiModelProperty("供应商")
    private String supplier;

    @JsonIgnore
    @ApiModelProperty("供应商租户编码")
    private String tenantCode;

    @ApiModelProperty("参考价格")
    private Double price;
}
