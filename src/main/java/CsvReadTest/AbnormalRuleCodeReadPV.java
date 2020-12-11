package CsvReadTest;

import sun.management.jdp.JdpException;

import java.io.*;
import java.util.*;

public class AbnormalRuleCodeReadPV {
    public static void main(String[] args) {
        readFile();
    }

    public static void readFile() {
        String pathname = "E:\\2020.11\\xinaoAbnormal.csv";
        File writeFile = new File(pathname);
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            Map<Long, String> map = new HashMap<>();
            int i = 2382;
            while ((line = br.readLine()) != null) {
                try {
                    String[] lineList = line.split(",");
                    String pointNumber = "111299999" + i;
                    String devId = lineList[0];
                    String measPn = lineList[1];
                    String bit = lineList[2];
                    String title = lineList[3];
                    System.out.println("match (d:Device),(al:AbnormalLevel{name:'Serious'}) where ID(d)=" + devId + " " +
                            "create (d)-[:HAS_ABNORMAL_RULE]->(ar:AbnormalRule{title:'" + title + "'})-[:ABNORMAL_LEVEL_OF" +
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
