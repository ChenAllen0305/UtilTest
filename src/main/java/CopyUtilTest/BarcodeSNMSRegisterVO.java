package CopyUtilTest;

import lombok.Data;

import java.util.List;

/**
 * ClassName: BarcodeSNMSRegisterVO
 * Author: yujianan
 * date: 2019/11/1/001
 * Description:
 */
@Data
public class BarcodeSNMSRegisterVO {
    private String handle;

    private String templateVersion;

    private List<BarcodeRegisterValueVO> value;

}
