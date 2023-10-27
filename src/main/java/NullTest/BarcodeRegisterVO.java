package NullTest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *  *ClassName：BarcodeRegisterVO
 *  *Author: yuanpeng
 *  *Date：2019/9/6/006 13:44
 *  *Description: 
 */
@Data
public class BarcodeRegisterVO {

    @ApiModelProperty(value = "标识来源")
    private String handleSource;

    @ApiModelProperty(value = "标识名称")
    private String handle;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    public boolean isValidHandle() {
        return true;
    }

    @ApiModelProperty(value = "模板版本")
    private String modelVersion;

    @ApiModelProperty(value = "创建人/修改人")
    private String personName;

    @ApiModelProperty("同步时间戳 - 由其他应用提供")
    private Long syncTimeStamp;

}
