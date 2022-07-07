package Field.object;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: HandleMessageDetail
 * @author: ChenLun
 * @date: 2022/4/26 9:54
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDetail {

    @ApiModelProperty("属性名称")
    private String name;

    @ApiModelProperty("属性编码")
    private String code;

    @ApiModelProperty("属性值")
    private String value;
}
