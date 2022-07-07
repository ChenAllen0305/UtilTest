package StringTest;

import java.nio.charset.StandardCharsets;

/**
 * @className: ShortMessageTest
 * @author: ChenLun
 * @date: 2022/4/6 11:35
 * @description:
 */
public class ShortMessageTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 1; i <= 70; i++) {
            sb.append("的");
            sb2.append("a");
        }
        String string1 = sb.toString();
        System.out.println("length1: " + string1.length());
        System.out.println("byte length1: " + string1.getBytes(StandardCharsets.UTF_8).length);

        sb.append("。");
        String string11 = sb.toString();
        System.out.println("length11: " + string11.length());
        System.out.println("byte length11: " + string11.getBytes(StandardCharsets.UTF_8).length);

        String string2 = sb2.toString();
        System.out.println("length2: " + string2.length());
        System.out.println("byte length2: " + string2.getBytes(StandardCharsets.UTF_8).length);


        String string3 = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
        System.out.println("length3: " + string3.length());
        System.out.println("byte length3: " + string3.getBytes(StandardCharsets.UTF_8).length);

        String string4 = "的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的的 ！、。，、/_%(12345judng";
        System.out.println("length4: " + string4.length());
        System.out.println("byte length4: " + string4.getBytes(StandardCharsets.UTF_8).length);
    }
}
