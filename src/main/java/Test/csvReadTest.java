package Test;

import jdk.internal.util.xml.impl.Input;

import java.io.*;

public class csvReadTest {
    public static void main(String[] args) {
        try{
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("D://dcs2sis.csv")), "UTF-8");
//            bufferedReader.readLine();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("D://123.csv"),"UTF-8"));
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                String item[] = line.split(",");

                String last = item[0];
                System.out.println(last);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No FIle");
        } catch (IOException e) {
            System.out.println("Read File Warn");
        }
    }
}
