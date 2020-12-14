package JPushUtilTest;

import java.util.HashMap;
import java.util.Map;

public class JPushTest {
    public static void main(String[] args) {
//        String content = "";
//        Map<String, String> msg = new HashMap<>();
//        content = "new alarm occurred";
////        content = "The SMA SC2200 Inverter of the station Yongala(谁动谁丑) has occurred with 支路4电流过大 on 2020-11-20 15:18:43";
////        content = "The SMA SC2200 Inverter of the station Yongala(谁动谁丑)";
//        msg.put("msg", content);
////        msg.put("title", "PushTitleTest");
//        msg.put("title", "push test");
//        JPushUtil.push(msg, "testAlarm");
        Map<String, String> param = new HashMap<>(2);
        String tag = "testAlarmAbcde";
        String content = "The abaabaabaabaabaabaaba";
        String title = "Alarm Occurred";
        param.put("msg", content);
        param.put("title", title);
        JPushUtil.push(param, tag);
    }
}
