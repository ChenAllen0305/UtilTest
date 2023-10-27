package MapTest;


import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MapEmptyTest {
    public static void main(String[] args) {
        Map<String, Map<String, String>> map = new HashMap<>();

        for (Map.Entry<String, Map<String, String>> entry : map.entrySet()) {
            log.info(entry.toString());
        }
    }
}
