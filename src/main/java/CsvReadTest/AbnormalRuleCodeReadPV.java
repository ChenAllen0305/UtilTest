package CsvReadTest;

import sun.management.jdp.JdpException;

import java.io.*;
import java.util.*;

public class AbnormalRuleCodeReadPV {
    public static void main(String[] args) {
        readFile();
    }

    public static void readFile() {
        String pathname = "E:\\abnormalRule.csv";
        File writeFile = new File(pathname);
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            Map<Long, String> map = new HashMap<>();
            int i = 171;
            int j = 41;
            while ((line = br.readLine()) != null) {
                try {
                    String[] lineList = line.split(",");
                    String pointNumber = 1110 + lineList[1];
                    String ruleTitle = lineList[0];
                    String in = "1110999950101";
                    String jn = "1110999950201";
                    String level = "Moderate";
//                    if (devTitle.equals("PCS1")) {
//                        String pointNumber1 = in + i;
//                        System.out.println("match (d:Device{title:'" + devTitle + "'}),(al:AbnormalLevel{name:'" + level + "'}) with d,al  " +
//                                "create (d)-[:HAS_ABNORMAL_RULE]-> (ar:AbnormalRule{title:'" + ruleTitle + "'})-[r1:ABNORMAL_LEVEL_OF{" +
//                                "formula:'var(" + pointNumber + ")!=0', " +
//                                "measPointNumberStr:'" + pointNumber + "'," +
//                                "measPointNumbers:[" + pointNumber + "]," +
//                                "pointNumber:" + pointNumber1 + "}]" +
//                                "->(al);");
//                        i++;
//                    } else {
//                        String pointNumber2 = jn + j;
//                        System.out.println("match (d:Device{title:'" + devTitle + "'}),(al:AbnormalLevel{name:'" + level + "'}) with d,al  " +
//                                "create (d)-[:HAS_ABNORMAL_RULE]-> (ar:AbnormalRule{title:'" + ruleTitle + "})-[r1:ABNORMAL_LEVEL_OF{" +
//                                "formula:'var(" + pointNumber + ")!=0', " +
//                                "measPointNumberStr:'" + pointNumber + "'," +
//                                "measPointNumbers:[" + pointNumber + "]," +
//                                "pointNumber:" + pointNumber2 + "}]" +
//                                "->(al);");
//                        j++;
//                    }
                    String pointNumber1 = in + i;
                    System.out.println("match (d:Device{title:'" + "4#集装箱" + "'}),(al:AbnormalLevel{name:'" + level + "'}) with d,al  " +
                            "create (d)-[:HAS_ABNORMAL_RULE]-> (ar:AbnormalRule{title:'" + ruleTitle + "'})-[r1:ABNORMAL_LEVEL_OF{" +
                            "formula:'var(" + pointNumber + ")!=0', " +
                            "measPointNumberStr:'" + pointNumber + "'," +
                            "measPointNumbers:[" + pointNumber + "]," +
                            "pointNumber:" + pointNumber1 + "}]" +
                            "->(al);");
                    i++;
                } catch (Exception e) {

                }
            }
//            BufferedWriter writeText = new BufferedWriter(new FileWriter(writeFile));
//            Set set = map.keySet();
//            Object[] arr=set.toArray();
//            Arrays.sort(arr);
//            for(Object key:arr){
////                System.out.println(key);
//                writeText.newLine();    //换行
//                //调用write的方法将字符串写到流中
//                writeText.write(key +","+map.get(key));
//            }
//            writeText.flush();
//            //关闭缓冲区，缓冲区没有调用系统底层资源，真正调用底层资源的是FileWriter对象，缓冲区仅仅是一个提高效率的作用
//            //因此，此处的close()方法关闭的是被缓存的流对象
//            writeText.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
