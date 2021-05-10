package CsvReadTest;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: BiaoshiRead
 * Author: ChenLun
 * date: 2021/5/10
 * Description:
 */
public class BiaoshiRead {
    public static void main(String[] args) {
        readFile();
    }

    public static void readFile() {
        String pathname = "E:\\original.csv";
        File writeFile = new File(pathname);
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            Map<Long, String> map = new HashMap<>();
            while ((line = br.readLine()) != null) {
                try {
                    String[] lineList = line.split(",");
                    String title1 = lineList[0];
                    String title2 = lineList[1];
                    String title3 = lineList[2];
                    String title4 = lineList[3];
                    String count = lineList[4];
                    String model = lineList[5];
                    String version = lineList[6];
                    String company = lineList[7];
                    String address = lineList[8];
                    String createTime = lineList[9];
                } catch (Exception e) {

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
