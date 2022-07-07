package PropertyTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * ClassName: PropertyTest
 * Author: ChenLun
 * date: 2021/10/22
 * Description:
 */
public class PropertyTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            String fileName = "src/main/resources/tenantLastId.properties";
//            FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
//            properties.setProperty("tenantCode", "9123125");
//            properties.store(fileOutputStream, fileName);
//            fileOutputStream.close();

            OutputStream outputStream = new FileOutputStream(fileName);
            properties.setProperty("tenantCode", "123123123");
            properties.store(outputStream, fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
