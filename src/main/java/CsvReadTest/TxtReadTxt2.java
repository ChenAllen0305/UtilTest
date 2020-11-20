package CsvReadTest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TxtReadTxt2 {
    public static void main(String[] args) {
        readFile();
    }

    private static void readFile() {
        String pathname = "E:\\2020.10\\analogTest2.txt";
        File f = new File(pathname);
        try (FileReader reader = new FileReader(pathname);
             InputStreamReader read = new InputStreamReader(new FileInputStream(f),"GBK");
             BufferedReader br = new BufferedReader(read);
        ) {
            String line;
            int i = 1027;
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
//                cypher += line;
//                if (cypher.contains(";")) {
//                    System.out.println(cypher);
//                    cypher = "";
//                }
                String title = strings[0].replace(" ","");
                String pointNumber = strings[1].replace(" ","");
                String bit = strings[2].replace(" ","");
                String description = strings[3].replace(" ","");
                String alarmLevel = strings[4].replace(" ","");
                String pointNumberStr = "100099999";
                pointNumberStr = pointNumberStr + i;

                System.out.println(
                        "match (dev:Device),(al:AlarmLevel{name:'" + alarmLevel + "'}) where ID(dev) = 23164 with dev,al   " +
                        "create (dev)-[:AHS_ABNORMAL_RULE]->(ar:AbnormalRule{title:'" + title + "'})-[r:ALARM_LEVEL_OF{" +
                        "formula:'var(" + pointNumber + ")@" + bit + "==1', " +
                        "measPointNumberStr:'" + pointNumber + "', measPointNumbers:[" + pointNumber +"], description:'" + description + "'," +
                        "pointNumber:" + pointNumberStr +"}]->(al);");
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
