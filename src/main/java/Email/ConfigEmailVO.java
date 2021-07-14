package Email;

//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConfigEmailVO {

//    @ApiModelProperty("类型")
    private String type;

//    @ApiModelProperty("服务地址")
    private String host;

//    @ApiModelProperty("账号")
    private String account;

//    @ApiModelProperty("授权码")
    private String password;
}
