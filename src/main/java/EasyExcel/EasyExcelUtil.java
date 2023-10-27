package EasyExcel;

import Util.TestFileUtil;
import com.alibaba.excel.EasyExcelFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: EasyExcelUtil
 * @author: ChenLun
 * @date: 2022/9/5 15:38
 * @description:
 */
@Slf4j
public class EasyExcelUtil {
    public static void main(String[] args) {
        String filePath = TestFileUtil.getPath() + "localTest" + System.currentTimeMillis() + ".xlsx";
        log.info("filePath: " + filePath);

        List<String> headers = new ArrayList<>();
        headers.add("handle1");
        headers.add("handle2");
        headers.add("handle3");
        headers.add("handle4");
        headers.add("handle5");
        headers.add("handle6");

        File file = new File(filePath);

        List<List<String>> headList = new ArrayList<>();
        for (String transHeader : headers) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(transHeader);
            headList.add(arrayList);
        }

//        EasyExcelFactory.write(filePath, ComplexHeadData.class).sheet("模板");

        EasyExcelFactory.write(file, ComplexHeadData.class).sheet("模板").doWrite(new ArrayList<>());

    }
}
