package CsvReadTest;

import sun.management.jdp.JdpException;

import java.io.*;
import java.util.*;

public class AbnormalRuleCodeReadPV {
    public static void main(String[] args) {
        readFile();
    }

    public static void readFile() {
        String pathname = "E:\\2021.01\\ZhaoqinClusterAbnormal.txt";
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
                    String devId = lineList[0];
                    String measPn = lineList[1];
                    String bit1 = lineList[2];
                    String bit2 = lineList[3];
                    String title = lineList[4];
                    System.out.println("match (dev:Device),(al:AbnormalLevel{name:'Slight'}) where ID(d)=" + devId + " " +
                            "create (d)-[:HAS_ABNORMAL_RULE]->(ar:AbnormalRule{title:'" + title + "一级故障'})-[:ABNORMAL_LEVEL_OF" +
                            "{formula:'(var(" + measPn + ")@" + bit1 + "==0)&(var(" + measPn + ")@" + bit2 + "==1))'," +
                            "measPointNumberStr:'" + measPn + "'," +
                            "measPointNumbers:[" + measPn + "]" +
                            "]->(al);");
                    System.out.println("match (dev:Device),(al:AbnormalLevel{name:'Moderate'}) where ID(d)=" + devId + " " +
                            "create (d)-[:HAS_ABNORMAL_RULE]->(ar:AbnormalRule{title:'" + title + "二级故障'})-[:ABNORMAL_LEVEL_OF" +
                            "{formula:'(var(" + measPn + ")@" + bit1 + "==1)&(var(" + measPn + ")@" + bit2 + "==0))'," +
                            "measPointNumberStr:'" + measPn + "'," +
                            "measPointNumbers:[" + measPn + "]" +
                            "]->(al);");
                    System.out.println("match (dev:Device),(al:AbnormalLevel{name:'Serious'}) where ID(d)=" + devId + " " +
                            "create (d)-[:HAS_ABNORMAL_RULE]->(ar:AbnormalRule{title:'" + title + "三级故障'})-[:ABNORMAL_LEVEL_OF" +
                            "{formula:'(var(" + measPn + ")@" + bit1 + "==1)&(var(" + measPn + ")@" + bit2 + "==1))'," +
                            "measPointNumberStr:'" + measPn + "'," +
                            "measPointNumbers:[" + measPn + "]" +
                            "]->(al);");
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
