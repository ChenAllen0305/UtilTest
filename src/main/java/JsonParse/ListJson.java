package JsonParse;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: ListJson
 * @author: ChenLun
 * @date: 2023/2/25 17:25
 * @description:
 */
@Slf4j
public class ListJson {
    public static void main(String[] args) {
        List<String> ids = new ArrayList<>();
        ids.add("17ee400c-f558-49f7-9ff6-54b1e6ab7a59");

        String json = JSON.toJSONString(ids);
        log.info(json);

        List<String> list = JSON.parseArray(json, String.class);
        log.info(list.toString());
    }
}
