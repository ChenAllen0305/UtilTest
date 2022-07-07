package Field.object;

import Field.enums.SubscribeTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @className: HandleMessage
 * @author: ChenLun
 * @date: 2022/4/26 9:52
 * @description:
 */
@Data
public class MessageBody {

    @ApiModelProperty("标识")
    private String handle;

    @ApiModelProperty("订阅消息类型")
    private SubscribeTypeEnum type;

    @ApiModelProperty("元数据ID")
    private String templateId;

    @ApiModelProperty("元数据版本ID")
    private String modelVersionId;

    @ApiModelProperty(value = "行业门类，示例：A")
    private String industryCategory;

    @ApiModelProperty(value = "行业大类，示例：01")
    private String industrySpecific;

    @ApiModelProperty(value = "行业中类，示例：011")
    private String industryTrade;

    @ApiModelProperty(value = "行业小类，示例：0111")
    private String industrySubclass;

    @ApiModelProperty("标识解析属性")
    private List<MessageDetail> details;
}
