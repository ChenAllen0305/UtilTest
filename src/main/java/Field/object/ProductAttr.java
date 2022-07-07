package Field.object;

import Field.enums.FormatEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: ProductAttr
 * @author: ChenLun
 * @date: 2022/4/21 18:10
 * @description: 产品属性
 */
@Data
public class ProductAttr {

    @ApiModelProperty("属性顺序")
    private Integer index;

    @ApiModelProperty("属性名称")
    private String name;

    @ApiModelProperty("属性编码")
    private String code;

    @ApiModelProperty(value = "类型")
    private FormatEnum type;
}
