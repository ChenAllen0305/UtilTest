package CsvReadTest;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CSVReadTest {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
//            br = new BufferedReader(new FileReader("E:\\export (7).csv"));
            br = new BufferedReader(new FileReader("E:\\battery23.txt"));
            String contentLine[] = br.readLine().split(",");
            System.out.println(contentLine.toString());
//            for (int i = 0; i<contentLine.length; i++) {
//                System.out.println(contentLine[i]);
//            }
            System.out.println("-------------");
//            Set set = new HashSet();
//            System.out.print("match (a:Analog) where a.pointNumber=");
            while (contentLine != null && contentLine.length > 0) {
                contentLine = br.readLine().split(";");
//                String s1 = contentLine[0];
//                if (!s1.equals("")) {
//                    System.out.println("match (n),(a:Analog) where ID(n)="+ s1 +" and a.pointNumber=" + s2 +" create (n)" +
//                            "-[:HAS_ANALOG{terminal:'default'}]->(a);");
//                    set.add(s1);
//                }
//                System.out.print(s2 + ",");
//                System.out.println("match (a:Area) where a.name='" + contentLine[1] + "' set a.weatherCode=" + contentLine[0] + " ;");
//                System.out.println("match (a:Area) where a.name='" + contentLine[1] + "' return a;");
                int size = contentLine.length;
                for (int i = 0; i<size; i++) {
                    System.out.print(contentLine[i] + ",");
                }
            }
//            System.out.println(" return a;");
//            for(Iterator it = set.iterator(); it.hasNext(); )
//            {
//                System.out.println("match (n) where ID(n)="+it.next().toString() + " return n;");
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Error in closing the BufferedReader");
            }
        }

    }
}
