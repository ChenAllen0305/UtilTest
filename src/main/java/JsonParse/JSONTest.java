package JsonParse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @className: JSONTest
 * @author: ChenLun
 * @date: 2022/1/10 17:33
 * @description:
 */
@Slf4j
public class JSONTest {
    public static void main(String[] args) {
        BarcodeAttrsEntity barcode1 = new BarcodeAttrsEntity("test1", "test1", "test1", 1);
        String barcode1String = JSON.toJSONString(barcode1);
        log.info(barcode1String);

        JSONObject parse1 = JSON.parseObject(barcode1String);
        log.info(parse1.toString());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("attrName", "test2");
        jsonObject.put("attrCode", "test2");
        jsonObject.put("attrValue", "test2");
        jsonObject.put("idx", 2);
        BarcodeAttrsEntity barcode2 = JSON.toJavaObject(jsonObject, BarcodeAttrsEntity.class);
        log.info(barcode2.toString());
    }
}
