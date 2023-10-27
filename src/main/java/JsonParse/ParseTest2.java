package JsonParse;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @className: ParseTest2
 * @author: ChenLun
 * @date: 2023/3/9 18:00
 * @description:
 */
public class ParseTest2 {
    public static void main(String[] args) {
        String json = "[{\"materialName\":\"扳手啊\",\"modifiedTime\":\"2023-03-06 18:05:46\",\"createdBy\":\"chenlun2\",\"factoryId\":\"23020997\",\"materialSpec\":\"1\",\"description\":\"范德萨发\",\"createdTime\":\"2023-03-03 17:53:47\",\"materialCode\":\"12\",\"modifiedBy\":\"chenlun2\",\"materialId\":\"1081273230074839040\",\"materialUnit\":\"厘米\",\"materialPrice\":20,\"quantity\":20},{\"materialName\":\"螺丝1\",\"modifiedTime\":\"2023-03-03 17:55:55\",\"createdBy\":\"chenlun2\",\"factoryId\":\"23020997\",\"materialSpec\":\"12\",\"description\":\"反倒是\",\"createdTime\":\"2023-03-03 17:54:06\",\"materialCode\":\"13\",\"modifiedBy\":\"chenlun2\",\"materialId\":\"1081273308776759296\",\"materialUnit\":\"厘米\",\"materialPrice\":32,\"quantity\":20}]";

        List<AddConsumables> addConsumablesList = JSON.parseArray(json, AddConsumables.class);
        System.out.println(addConsumablesList.toArray());
    }
}
