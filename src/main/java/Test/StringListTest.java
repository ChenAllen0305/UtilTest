package Test;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringListTest {

//    private Map<String, String> alarmLevelMap = new HashMap<>(4);

//    @PostConstruct
//    private void init() {
//        alarmLevelMap.put(ALARMLEVEL.IGNORE.code, ALARMLEVEL.IGNORE.title);
//        alarmLevelMap.put(ALARMLEVEL.SLIGHT.code, ALARMLEVEL.SLIGHT.title);
//        alarmLevelMap.put(ALARMLEVEL.MODERATE.code, ALARMLEVEL.MODERATE.title);
//        alarmLevelMap.put(ALARMLEVEL.SERIOUS.code, ALARMLEVEL.SERIOUS.title);
//    }

    public static void main(String[] args) {
        Map<String, String> alarmLevelMap = new HashMap<>(4);
        alarmLevelMap.put(ALARMLEVEL.IGNORE.code, ALARMLEVEL.IGNORE.title);
        alarmLevelMap.put(ALARMLEVEL.SLIGHT.code, ALARMLEVEL.SLIGHT.title);
        alarmLevelMap.put(ALARMLEVEL.MODERATE.code, ALARMLEVEL.MODERATE.title);
        alarmLevelMap.put(ALARMLEVEL.SERIOUS.code, ALARMLEVEL.SERIOUS.title);

        String test = "3,4";
//        List<String> list = Arrays.asList(test.split(","));
        String[] array = test.split(",");
        String result = "";
        for (String s : array) {
            result += alarmLevelMap.get(s) + ",";
        }
        System.out.println(result.substring(0, result.length()-1));
    }

    public enum ALARMLEVEL {
        IGNORE("1", "忽略"),
        SLIGHT("2", "轻微"),
        MODERATE("3", "中度"),
        SERIOUS("4", "严重");
//        IGNORE("1", "ignore"),
//        SLIGHT("2", "slight"),
//        MODERATE("3", "moderate"),
//        SERIOUS("4", "serious");

        private String code;
        private String title;
        ALARMLEVEL(String code, String title) {
            this.code = code;
            this.title = title;
        }
        public String code() {
            return code;
        }
        public String title() {
            return title;
        }
    }
}

