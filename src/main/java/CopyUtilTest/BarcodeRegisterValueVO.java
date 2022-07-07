package CopyUtilTest;

import lombok.Data;

/**
 *  *ClassName：BarcodeRegisterValueVO
 *  *Author: yuanpeng
 *  *Date：2019/9/9/009 14:10
 *  *Description: 
 */
@Data
public class BarcodeRegisterValueVO {
    private BacodeSelectResultDataVO data;

    //    @JsonIgnore
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    @ApiModelProperty(hidden = true)
    private String auth;

    //    @JsonIgnore
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)//WRITE_ONLY:仅做反序列化操作。    READ_ONLY：仅做序列化操作。
//    @ApiModelProperty(hidden = true)
    private int index;

    private String type;
}


