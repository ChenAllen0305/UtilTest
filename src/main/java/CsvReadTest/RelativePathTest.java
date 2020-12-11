package CsvReadTest;

import java.io.*;
import java.util.*;

public class RelativePathTest {
    public static void main(String[] args) {
        readFile();
    }

    public static void readFile() {
        String pathname = "E:\\2020.11\\AliBmsAbnormal.txt";
        File writeFile = new File(pathname);
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            Set set = new HashSet();
            while ((line = br.readLine()) != null) {
                try {
                    //--------更改阿里取位数
                    String start = line.substring(0, line.indexOf("@")+1);
                    int i = Integer.valueOf(line.substring(line.indexOf("@")+1, line.indexOf("=="))) + 1;
                    String end = line.substring(line.indexOf("=="));
                    System.out.println(start + i + end);
//                    int ids = line.indexOf("ID(dev)= ") + 9;
//                    int ide = line.indexOf(" with");
//                    System.out.println(line.substring(ids, ide));
//                    set.add(Integer.valueOf(line.substring(ids, ide)));
//                    System.out.println(line);
                } catch (Exception e) {

                }
            }
//            System.out.println(set);
//            for (Iterator it = set.iterator(); it.hasNext(); ) {
//                Integer i  = (Integer) it.next();
//                System.out.println("match (dev)-[:AHS_ABNORMAL_RULE]->(ar:AbnormalRule) where ID(dev)=" + i + " detach delete ar;");
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
