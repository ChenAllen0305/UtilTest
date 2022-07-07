package MapTest;

import Util.EmptyUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @className: StringListMapTest
 * @author: ChenLun
 * @date: 2022/5/11 19:24
 * @description:
 */
@Slf4j
public class StringListMapTest {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();

        insertValue(map, "prefix1", "templateId1");
        log.info(map.toString());
        insertValue(map, "prefix1", "templateId2");
        log.info(map.toString());
    }

    private static void insertValue(Map<String, List<String>> prefixTemplateIdsMap, String prefix, String templateId) {
        List<String> templateIds = prefixTemplateIdsMap.get(prefix);
        if (EmptyUtil.isEmpty(templateIds)) {
            templateIds = new ArrayList<>(Collections.singleton(templateId));
            prefixTemplateIdsMap.put(prefix, templateIds);
        } else {
            templateIds.add(templateId);
        }
    }
}
