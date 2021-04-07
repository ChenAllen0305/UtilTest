package CsvReadTest;

import Util.StringUtil;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AbnormalRuleZhaoqin {
    public static void main(String[] args) {
        readFile();
    }

    public static void readFile() {
        String pathname = "E:\\2021.02\\zqdq.csv";
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] lineList = line.split(",");
                    String devId = lineList[0];
                    String measPn = lineList[4];
                    String title = lineList[1];
                    String result = lineList[2];
                    String level = lineList[3];
                    if ("Ignore".equals(level)) {
                        continue;
                    }
                    if (StringUtil.isEmpty(level)) {
                        continue;
                    }
                    System.out.println("match (d:Device),(al:AlarmLevel{name:'" + level + "'}) where ID(d)=" + devId + " " +
                            "create (d)-[:HAS_ABNORMAL_RULE]->(ar:AbnormalRule{title:'" + title + "'})-[:ALARM_LEVEL_OF" +
                            "{formula:'var(" + measPn + ")==" + result + "'," +
                            "measPointNumberStr:'" + measPn + "'," +
                            "measPointNumbers:[" + measPn + "]" +
                            "}]->(al);");
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
