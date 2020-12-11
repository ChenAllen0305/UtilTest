package CsvReadTest;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PointDataTypeOutputForXinao {
    public static void main(String[] args) {
        readFile();
    }

    public static void readFile() {
        String pathname = "E:\\2020.11\\XinaoPdt.csv";
        File writeFile = new File(pathname);
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            int i = 1;
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] lineList = line.split(",");
                    Long timestamp = new Date().getTime();
                    String title = lineList[0];
                    String name = lineList[1];
                    System.out.println("create (p:PointDataType{title:'" + title + "',name:'" + name + "',sn:" + timestamp + "}) return 1;");
                    if (i % 100 == 0) {
                        System.out.println("----------------" + i);
                    }
                    i++;
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
