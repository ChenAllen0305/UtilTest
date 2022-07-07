package CopyUtilTest;

import lombok.Data;

import java.util.List;


/**
 *  *ClassName：BarcodeRegisterVO
 *  *Author: yuanpeng
 *  *Date：2019/9/6/006 13:44
 *  *Description: 
 */
@Data
public class BarcodeRegisterVO {
    private String handle;

    private String templateVersion;

    private List<BarcodeRegisterValueVO> value;

}
