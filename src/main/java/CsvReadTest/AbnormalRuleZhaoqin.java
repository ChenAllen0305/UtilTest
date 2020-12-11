package CsvReadTest;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AbnormalRuleZhaoqin {
    public static void main(String[] args) {
        readFile();
    }

    public static void readFile() {
        String pathname = "E:\\2020.11\\ZhaoqinPcs.csv";
        File writeFile = new File(pathname);
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            Map<Long, String> map = new HashMap<>();
            int i = 21;
            while ((line = br.readLine()) != null) {
                try {
                    String[] lineList = line.split(",");
                    String pointNumber = "110499999" + i;
                    String devId = lineList[0];
                    String measPn = "1104" +lineList[1];
                    String bit = lineList[2];
                    String title = lineList[3];
                    String level = lineList[4];
                    System.out.println("match (d:Device),(al:AlarmLevel{name:'" + level + "'}) where ID(d)=" + devId + " " +
                            "create (d)-[:HAS_ABNORMAL_RULE]->(ar:AbnormalRule{title:'" + title + "'})-[:ALARM_LEVEL_OF" +
                            "{formula:'var(" + measPn + ")@" + bit + "==1'," +
                            "measPointNumberStr:'" + measPn + "'," +
                            "measPointNumbers:[" + measPn + "]," +
                            "pointNumber:" + pointNumber + "}" +
                            "]->(al);");

                    i++;
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
