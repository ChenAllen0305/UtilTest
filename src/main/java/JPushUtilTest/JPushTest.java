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
        Map<String, String> param = new HashMap<>();
//        String tag = "testAlarm";
//        String tag = "testAbcdAbcdefgh";
//        String tag = "test_537847_15068834802";
        String tag = "alarm_82195_4057";
//        String tag = "alarm_180462_275070";
//        String tag = "test_537847_15005877988";
        String content = "The SMA SC2200 Inverter of the station Yongala(谁动谁丑)";
        String title = "Alarm Occurred";
        param.put("msg", content);
        param.put("title", title);
        JPushUtil.push(param, tag);
        System.exit(0);
    }
}
