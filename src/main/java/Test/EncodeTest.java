package Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class EncodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 设置文件后缀
        String fileName = "数据模板.csv";
        // 读取字符编码
        String utf = "UTF-8";
        String result = URLEncoder.encode(fileName, utf);
        System.out.println(result);
        System.out.println(java.net.URLDecoder.decode(result, "UTF-8"));
    }
}
