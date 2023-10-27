package NullTest;

import Util.EmptyUtil;
import Util.OrderlyUuidUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: NullTest1
 * @author: ChenLun
 * @date: 2023/5/8 10:10
 * @description:
 */
@Slf4j
public class NullTest1 {
    public static void main(String[] args) {
        OrderlyUuidUtil orderlyUuidUtil = new OrderlyUuidUtil();
        Map<String, BarcodeRegisterVO> barcodeMap = new HashMap<>();

        BarcodeRegisterVO existsBarcode = new BarcodeRegisterVO();
        Long oldId = orderlyUuidUtil.nextId();
        Long newId = orderlyUuidUtil.nextId();
        existsBarcode.setSyncTimeStamp(oldId);
        barcodeMap.put("barcode1", existsBarcode);


        if (EmptyUtil.isEmpty(existsBarcode)
                || EmptyUtil.isEmpty(existsBarcode.getSyncTimeStamp())
                || existsBarcode.getSyncTimeStamp() < newId) {
            log.info("不用更新");
        }

        if (EmptyUtil.isEmpty(existsBarcode)
                || (!EmptyUtil.isEmpty(existsBarcode) && existsBarcode.getSyncTimeStamp() < newId)) {
            log.info("不用更新");
        }

        BarcodeRegisterVO barcode2 = barcodeMap.get("barcode2");
        if (EmptyUtil.isEmpty(barcode2)
                || (!EmptyUtil.isEmpty(barcode2) && barcode2.getSyncTimeStamp() < newId)) {
            log.info("需要更新");
        }

    }
}
