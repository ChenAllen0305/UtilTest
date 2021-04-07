package StringTest;

/**
 * @title: ReplaceTest
 * @Author Chen Lun
 * @Date: 2021/3/30
 */
public class ReplaceTest {
    public static void main(String[] args) {
        String description = "You has shared your site stationTitle with user userName.";
        String stationTitle = "stationTest";
        System.out.println(description);
        System.out.println(stationTitle);
//        description.replaceAll(PushRecordTemplateConstant.REPLACEMENT.STATION_TITLE.value(), stationTitle);
        String result = description.replace("stationTitle", stationTitle);
        System.out.println(result);
        description.replace("You", "test");
        System.out.println(description);
        String desc1 = description;
        desc1.replace("stationTitle", stationTitle);
        System.out.println(desc1);
    }
}
