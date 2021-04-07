package CsvReadTest;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @title: AbnormalReplace
 * @Author Chen Lun
 * @Date: 2021/2/5
 */
public class AbnormalReplace {
    public static void main(String[] args) {
        readFile();
    }

    public static void readFile() {
        String pathname = "E:\\2021.02\\SBMSchannel4.txt";
        File writeFile = new File(pathname);
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            Map<Long, String> map = new HashMap<>();
            int i = 2382;
            while ((line = br.readLine()) != null) {
                try {
                    if (line.contains("/")) {
                        System.out.println(line);
                        continue;
                    }
                    if (line.contains("delete")) {
                        System.out.println(line);
                        continue;
                    }
                    if (!line.contains("pointNumber:110499999")){
                        System.out.println(line);
                        continue;
                    }
                    int lastComma = line.lastIndexOf(",");
                    int lastBrackets = line.lastIndexOf("}");
                    System.out.println(line.substring(0, lastComma) + line.substring(lastBrackets));
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
