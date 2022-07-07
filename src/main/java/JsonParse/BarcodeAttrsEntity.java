package JsonParse;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *  *ClassName：BarcodeAttrsEntity
 *  *Author: yuanpeng
 *  *Date：2019/9/11/011 11:33
 *  *Description: 
 */
@Data
@AllArgsConstructor
public class BarcodeAttrsEntity {
    private String attrName;

    private String attrCode;

    private String attrValue;

    private int idx;
}
