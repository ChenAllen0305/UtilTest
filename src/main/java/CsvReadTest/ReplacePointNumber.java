package CsvReadTest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReplacePointNumber {
    public static void main(String[] args) {
        readFile();
    }

    private static void readFile() {
//        String pathname = "E:\\2020.09\\ESBCM1.txt";
//        String pathname = "E:\\2020.09\\ESMU1.txt";
        String pathname = "E:\\2020.09\\PCS1.txt";
        File f = new File(pathname);
        try (FileReader reader = new FileReader(pathname);
             InputStreamReader read = new InputStreamReader(new FileInputStream(f),"GBK");
             BufferedReader br = new BufferedReader(read);
//             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            int i = 1;
            String line;
            while ((line = br.readLine()) != null) {
//                String[] lineList = line.split(";");
//                System.out.println(lineList);
                if (line.contains("pointNumber")) {
                    System.out.println("pointNumber:" + "1110999950301"  + i + "}]");
                    i ++;
                } else {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
