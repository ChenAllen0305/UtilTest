package CsvReadTest;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PointNumberReadTest {
    public static void main(String[] args) {
    readFile();
}

    public static void readFile() {
        String pathname = "E:\\pointNumber.csv";
        File writeFile = new File(pathname);
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            Map<Long, String> map = new HashMap<>();
            while ((line = br.readLine()) != null) {
                try {
                    String[] lineList = line.split(",");
                    String deviceTitle = lineList[0];
                    String pdt = lineList[6];
                    if (!deviceTitle.contains("BC#1_") || !deviceTitle.contains("BC#2_")) {
                        if (pdt.equals("温度")) {
                            System.out.println(line);
                        }

                    }
//                    System.out.println(line);
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
