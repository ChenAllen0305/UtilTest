package CsvReadTest;

import java.io.*;
import java.util.*;

public class TxtReadTest {
    private static Map<String, Long> ClusterIdMap = new HashMap<>();
    private static Map<String, Long> UnitIdMap = new HashMap<>();
    private static Map<Long, List<Long>> idVolMap = new HashMap<>();


    public static void main(String[] args) {
        intiClusterIdMap();
        intiUnitIdMap();
//        readFile();
        readFile2();
//        writeFile();
//        mapOutput();
    }

    public static void readFile() {
//        String pathname = "E:\\battery.txt"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        String pathname = "E:\\alarmValue.txt";
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            int j = 1;
            String is = "110499992999";
            Long i = 1L;
            //网友推荐更加简洁的写法
            List<String> list = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
//                System.out.println(line);
                try {
                    String[] lineList = line.split(" ");
                    String title = lineList[1].substring(9);
//                    String title = lineList[1].substring(5);
                    String pointNumber = lineList[2].substring(4,8);
//                    String pointNumber = lineList[2].substring(4,14);
                    String description = lineList[1].substring(17);
//                    String description = lineList[1].substring(8);
                    String deviceTitle = lineList[1].substring(0,13);
//                    String deviceTitle = lineList[1].substring(0,8);

                    String pointNumberStr = is + String.valueOf(i);
//                    System.out.println(title + " " + pointNumber + " " + description + " " + deviceTitle);
//                    System.out.println(deviceTitle);
//                    String deviceTitle = lineList[1].substring(0,8);
                    list.add(pointNumber);

//                    System.out.println("match (dev:Device) where ID(dev)= " + UnitIdMap.get(deviceTitle) + " with dev " +
//                            "create (dev)-[:AHS_ABNORMAL_RULE]->(ar" + j + ":AbnormalRule{title:'" + title + "'})-[r" + j + ":ALARM_LEVEL_OF{formula:'(" + lineList[2] +
//                        ")==1', measPointNumberStr:'" + pointNumber + "', measPointNumbers:[" + pointNumber +"], description:'" + description + "'," +
//                            "pointNumber:" + pointNumberStr +"}]->(moderate:AlarmLevel{name:'Moderate'});");
                } catch (Exception e) {

                }
//                System.out.println(deviceTitle);
//                System.out.println(title);
//                System.out.println(pointNumber);
//                System.out.println(description);
//                if (title.contains("电池簇1")) {
//                    System.out.println("(d1)-[:AHS_ABNORMAL_RULE]->(ar" + j + ":AbnormalRule{title:'" + title + "'})-[r" + j + ":ALARM_LEVEL_OF{formula:'(" + lineList[2] +
//                            ")==1', measPointNumberStr:'" + pointNumber + "', measPointNumbers:[" + pointNumber +"], description:'" + description + "',pointNumber:" + i +"}]->(moderate),");
//                } else if (title.contains("电池簇2")) {
//                    System.out.println("(d2)-[:AHS_ABNORMAL_RULE]->(ar" + j + ":AbnormalRule{title:'" + title + "'})-[r" + j + ":ALARM_LEVEL_OF{formula:'(" + lineList[2] +
//                            ")==1', measPointNumberStr:'" + pointNumber + "', measPointNumbers:[" + pointNumber +"], description:'" + description + "',pointNumber:" + i +"}]->(moderate),");
//                } else if (title.contains("电池簇3")) {
//                    System.out.println("(d3)-[:AHS_ABNORMAL_RULE]->(ar" + j + ":AbnormalRule{title:'" + title + "'})-[r" + j + ":ALARM_LEVEL_OF{formula:'(" + lineList[2] +
//                            ")==1', measPointNumberStr:'" + pointNumber + "', measPointNumbers:[" + pointNumber +"], description:'" + description + "',pointNumber:" + i +"}]->(moderate),");
//                } else if (title.contains("电池簇4")) {
//                    System.out.println("(d4)-[:AHS_ABNORMAL_RULE]->(ar" + j + ":AbnormalRule{title:'" + title + "'})-[r" + j + ":ALARM_LEVEL_OF{formula:'(" + lineList[2] +
//                            ")==1', measPointNumberStr:'" + pointNumber + "', measPointNumbers:[" + pointNumber +"], description:'" + description + "',pointNumber:" + i +"}]->(moderate),");
//                } else if (title.contains("电池簇5")) {
//                    System.out.println("(d5)-[:AHS_ABNORMAL_RULE]->(ar" + j + ":AbnormalRule{title:'" + title + "'})-[r" + j + ":ALARM_LEVEL_OF{formula:'(" + lineList[2] +
//                            ")==1', measPointNumberStr:'" + pointNumber + "', measPointNumbers:[" + pointNumber +"], description:'" + description + "',pointNumber:" + i +"}]->(moderate),");
//                } else if (title.contains("电池簇6")) {
//                    System.out.println("(d6)-[:AHS_ABNORMAL_RULE]->(ar" + j + ":AbnormalRule{title:'" + title + "'})-[r" + j + ":ALARM_LEVEL_OF{formula:'(" + lineList[2] +
//                            ")==1', measPointNumberStr:'" + pointNumber + "', measPointNumbers:[" + pointNumber +"], description:'" + description + "',pointNumber:" + i +"}]->(moderate),");
//                } else if (title.contains("电池簇7")) {
//                    System.out.println("(d7)-[:AHS_ABNORMAL_RULE]->(ar" + j + ":AbnormalRule{title:'" + title + "'})-[r" + j + ":ALARM_LEVEL_OF{formula:'(" + lineList[2] +
//                            ")==1', measPointNumberStr:'" + pointNumber + "', measPointNumbers:[" + pointNumber +"], description:'" + description + "',pointNumber:" + i +"}]->(moderate),");
//                } else if (title.contains("电池簇8")) {
//                    System.out.println("(d8)-[:AHS_ABNORMAL_RULE]->(ar" + j + ":AbnormalRule{title:'" + title + "'})-[r" + j + ":ALARM_LEVEL_OF{formula:'(" + lineList[2] +
//                            ")==1', measPointNumberStr:'" + pointNumber + "', measPointNumbers:[" + pointNumber +"], description:'" + description + "',pointNumber:" + i +"}]->(moderate),");
//                } else if (title.contains("电池簇9")) {
//                    System.out.println("(d9)-[:AHS_ABNORMAL_RULE]->(ar" + j + ":AbnormalRule{title:'" + title + "'})-[r" + j + ":ALARM_LEVEL_OF{formula:'(" + lineList[2] +
//                            ")==1', measPointNumberStr:'" + pointNumber + "', measPointNumbers:[" + pointNumber +"], description:'" + description + "',pointNumber:" + i +"}]->(moderate),");
//                }
//                System.out.println("insert into meas_sjzb values((select sjid from (select max(sjid)+1 as sjid from meas_sjzb) t1)," + i + ",1,1);");

                j++;
                i++;
            }
            HashSet<String> set = new HashSet<>(list);
            list.clear();
            list.addAll(set);
            for (String s : list) {
//                System.out.println("map.put( \"" + s + "\" ,);");
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile2() {
        String pathname = "E:\\VoltageMeasPointNumber.txt";
        int i = 1;
//        String pathname = "E:\\VoltageId.txt";
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                try {
                    if (i < 4) {
                        System.out.print( "1104" + line + ",");
                        i++;
                    } else {
                        System.out.println( "1104" + line);
                        i = 1;
                    }
                } catch (Exception e) {

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mapOutput(){
        for (Map.Entry<String, Long> entry : ClusterIdMap.entrySet()) {
            System.out.println("match (dev:Device)-[:AHS_ABNORMAL_RULE]->(ar:AbnormalRule)-[r:ALARM_LEVEL_OF]->(al:AlarmLevel) " +
                    "where ID(dev)=" + entry.getValue() + " and ar.title contains '单体互差过大故障' set r.relatedPointNumbers = [];");
        }
    }

    public static void intiClusterIdMap() {
        ClusterIdMap.put( "通道1-分系统1-电池簇1" ,68087L);
        ClusterIdMap.put( "通道1-分系统1-电池簇2" ,67887L);
        ClusterIdMap.put( "通道1-分系统1-电池簇3" ,59515L);
        ClusterIdMap.put( "通道1-分系统1-电池簇4" ,67642L);
        ClusterIdMap.put( "通道1-分系统1-电池簇5" ,70610L);
        ClusterIdMap.put( "通道1-分系统1-电池簇6" ,60502L);
        ClusterIdMap.put( "通道1-分系统1-电池簇7" ,69211L);
        ClusterIdMap.put( "通道1-分系统1-电池簇8" ,54464L);
        ClusterIdMap.put( "通道1-分系统1-电池簇9" ,69246L);

        ClusterIdMap.put( "通道1-分系统2-电池簇1" ,66170L);
        ClusterIdMap.put( "通道1-分系统2-电池簇2" ,57188L);
        ClusterIdMap.put( "通道1-分系统2-电池簇3" ,68125L);
        ClusterIdMap.put( "通道1-分系统2-电池簇4" ,69893L);
        ClusterIdMap.put( "通道1-分系统2-电池簇5" ,66838L);
        ClusterIdMap.put( "通道1-分系统2-电池簇6" ,64075L);
        ClusterIdMap.put( "通道1-分系统2-电池簇7" ,66590L);
        ClusterIdMap.put( "通道1-分系统2-电池簇8" ,66745L);
        ClusterIdMap.put( "通道1-分系统2-电池簇9" ,69127L);

        ClusterIdMap.put( "通道2-分系统1-电池簇1" ,55187L);
        ClusterIdMap.put( "通道2-分系统1-电池簇2" ,60318L);
        ClusterIdMap.put( "通道2-分系统1-电池簇3" ,69319L);
        ClusterIdMap.put( "通道2-分系统1-电池簇4" ,64505L);
        ClusterIdMap.put( "通道2-分系统1-电池簇5" ,70578L);
        ClusterIdMap.put( "通道2-分系统1-电池簇6" ,69782L);
        ClusterIdMap.put( "通道2-分系统1-电池簇7" ,19538L);
        ClusterIdMap.put( "通道2-分系统1-电池簇8" ,67777L);
        ClusterIdMap.put( "通道2-分系统1-电池簇9" ,65228L);

        ClusterIdMap.put( "通道2-分系统2-电池簇1" ,64614L);
        ClusterIdMap.put( "通道2-分系统2-电池簇2" ,68170L);
        ClusterIdMap.put( "通道2-分系统2-电池簇3" ,68169L);
        ClusterIdMap.put( "通道2-分系统2-电池簇4" ,70917L);
        ClusterIdMap.put( "通道2-分系统2-电池簇5" ,64977L);
        ClusterIdMap.put( "通道2-分系统2-电池簇6" ,63898L);
        ClusterIdMap.put( "通道2-分系统2-电池簇7" ,66068L);
        ClusterIdMap.put( "通道2-分系统2-电池簇8" ,70947L);
        ClusterIdMap.put( "通道2-分系统2-电池簇9" ,66580L);

        ClusterIdMap.put( "通道3-分系统1-电池簇1" ,66524L);
        ClusterIdMap.put( "通道3-分系统1-电池簇2" ,70916L);
        ClusterIdMap.put( "通道3-分系统1-电池簇3" ,57105L);
        ClusterIdMap.put( "通道3-分系统1-电池簇4" ,67543L);
        ClusterIdMap.put( "通道3-分系统1-电池簇5" ,70988L);
        ClusterIdMap.put( "通道3-分系统1-电池簇6" ,69028L);
        ClusterIdMap.put( "通道3-分系统1-电池簇7" ,68514L);
        ClusterIdMap.put( "通道3-分系统1-电池簇8" ,70053L);
        ClusterIdMap.put( "通道3-分系统1-电池簇9" ,70695L);

        ClusterIdMap.put( "通道3-分系统2-电池簇1" ,57368L);
        ClusterIdMap.put( "通道3-分系统2-电池簇2" ,68808L);
        ClusterIdMap.put( "通道3-分系统2-电池簇3" ,70617L);
        ClusterIdMap.put( "通道3-分系统2-电池簇4" ,64709L);
        ClusterIdMap.put( "通道3-分系统2-电池簇5" ,65686L);
        ClusterIdMap.put( "通道3-分系统2-电池簇6" ,62126L);
        ClusterIdMap.put( "通道3-分系统2-电池簇7" ,68206L);
        ClusterIdMap.put( "通道3-分系统2-电池簇8" ,65654L);
        ClusterIdMap.put( "通道3-分系统2-电池簇9" ,64998L);

        ClusterIdMap.put( "通道4-分系统1-电池簇1" ,62490L);
        ClusterIdMap.put( "通道4-分系统1-电池簇2" ,67089L);
        ClusterIdMap.put( "通道4-分系统1-电池簇3" ,63326L);
        ClusterIdMap.put( "通道4-分系统1-电池簇4" ,61583L);
        ClusterIdMap.put( "通道4-分系统1-电池簇5" ,66805L);
        ClusterIdMap.put( "通道4-分系统1-电池簇6" ,69385L);
        ClusterIdMap.put( "通道4-分系统1-电池簇7" ,69108L);
        ClusterIdMap.put( "通道4-分系统1-电池簇8" ,54864L);
        ClusterIdMap.put( "通道4-分系统1-电池簇9" ,67693L);

        ClusterIdMap.put( "通道4-分系统2-电池簇1" ,69989L);
        ClusterIdMap.put( "通道4-分系统2-电池簇2" ,65550L);
        ClusterIdMap.put( "通道4-分系统2-电池簇3" ,67896L);
        ClusterIdMap.put( "通道4-分系统2-电池簇4" ,66953L);
        ClusterIdMap.put( "通道4-分系统2-电池簇5" ,68314L);
        ClusterIdMap.put( "通道4-分系统2-电池簇6" ,66071L);
        ClusterIdMap.put( "通道4-分系统2-电池簇7" ,65969L);
        ClusterIdMap.put( "通道4-分系统2-电池簇8" ,63574L);
        ClusterIdMap.put( "通道4-分系统2-电池簇9" ,68782L);
    }

    public static void intiUnitIdMap() {
        UnitIdMap.put( "通道1-分系统1" ,72016L);
        UnitIdMap.put( "通道1-分系统2" ,58425L);
        UnitIdMap.put( "通道2-分系统1" ,67672L);
        UnitIdMap.put( "通道2-分系统2" ,65430L);
        UnitIdMap.put( "通道3-分系统1" ,68869L);
        UnitIdMap.put( "通道3-分系统2" ,65921L);
        UnitIdMap.put( "通道4-分系统1" ,66452L);
        UnitIdMap.put( "通道4-分系统2" ,64242L);
    }

    public static void intiClusterVolIdMap() {
//        idVolMap.put(68087L, new ArrayList<Long>(11041001400110010L,
//                11041001400110011L,
//                11041001400110014L,
//                11041001400110015L));
//        ClusterVolIdMap.put( "通道1-分系统1-电池簇3" ,67887L);
//        ClusterVolIdMap.put( "通道1-分系统1-电池簇3" ,59515L);
//        ClusterVolIdMap.put( "通道1-分系统1-电池簇4" ,67642L);
//        ClusterVolIdMap.put( "通道1-分系统1-电池簇5" ,70610L);
//        ClusterVolIdMap.put( "通道1-分系统1-电池簇6" ,60502L);
//        ClusterVolIdMap.put( "通道1-分系统1-电池簇7" ,69211L);
//        ClusterVolIdMap.put( "通道1-分系统1-电池簇8" ,54464L);
//        ClusterVolIdMap.put( "通道1-分系统1-电池簇9" ,69246L);
//
//        ClusterVolIdMap.put( "通道1-分系统2-电池簇1" ,66170L);
//        ClusterVolIdMap.put( "通道1-分系统2-电池簇2" ,57188L);
//        ClusterVolIdMap.put( "通道1-分系统2-电池簇3" ,68125L);
//        ClusterVolIdMap.put( "通道1-分系统2-电池簇4" ,69893L);
//        ClusterVolIdMap.put( "通道1-分系统2-电池簇5" ,66838L);
//        ClusterVolIdMap.put( "通道1-分系统2-电池簇6" ,64075L);
//        ClusterVolIdMap.put( "通道1-分系统2-电池簇7" ,66590L);
//        ClusterVolIdMap.put( "通道1-分系统2-电池簇8" ,66745L);
//        ClusterVolIdMap.put( "通道1-分系统2-电池簇9" ,69127L);
//
//        ClusterVolIdMap.put( "通道2-分系统1-电池簇1" ,55187L);
//        ClusterVolIdMap.put( "通道2-分系统1-电池簇2" ,60318L);
//        ClusterVolIdMap.put( "通道2-分系统1-电池簇3" ,69319L);
//        ClusterVolIdMap.put( "通道2-分系统1-电池簇4" ,64505L);
//        ClusterVolIdMap.put( "通道2-分系统1-电池簇5" ,70578L);
//        ClusterVolIdMap.put( "通道2-分系统1-电池簇6" ,69782L);
//        ClusterVolIdMap.put( "通道2-分系统1-电池簇7" ,19538L);
//        ClusterVolIdMap.put( "通道2-分系统1-电池簇8" ,67777L);
//        ClusterVolIdMap.put( "通道2-分系统1-电池簇9" ,65228L);
//
//        ClusterVolIdMap.put( "通道2-分系统2-电池簇1" ,64614L);
//        ClusterVolIdMap.put( "通道2-分系统2-电池簇2" ,68170L);
//        ClusterVolIdMap.put( "通道2-分系统2-电池簇3" ,68169L);
//        ClusterVolIdMap.put( "通道2-分系统2-电池簇4" ,70917L);
//        ClusterVolIdMap.put( "通道2-分系统2-电池簇5" ,64977L);
//        ClusterVolIdMap.put( "通道2-分系统2-电池簇6" ,63898L);
//        ClusterVolIdMap.put( "通道2-分系统2-电池簇7" ,66068L);
//        ClusterVolIdMap.put( "通道2-分系统2-电池簇8" ,70947L);
//        ClusterVolIdMap.put( "通道2-分系统2-电池簇9" ,66580L);
//
//        ClusterVolIdMap.put( "通道3-分系统1-电池簇1" ,66524L);
//        ClusterVolIdMap.put( "通道3-分系统1-电池簇2" ,70916L);
//        ClusterVolIdMap.put( "通道3-分系统1-电池簇3" ,57105L);
//        ClusterVolIdMap.put( "通道3-分系统1-电池簇4" ,67543L);
//        ClusterVolIdMap.put( "通道3-分系统1-电池簇5" ,70988L);
//        ClusterVolIdMap.put( "通道3-分系统1-电池簇6" ,69028L);
//        ClusterVolIdMap.put( "通道3-分系统1-电池簇7" ,68514L);
//        ClusterVolIdMap.put( "通道3-分系统1-电池簇8" ,70053L);
//        ClusterVolIdMap.put( "通道3-分系统1-电池簇9" ,70695L);
//
//        ClusterVolIdMap.put( "通道3-分系统2-电池簇1" ,57368L);
//        ClusterVolIdMap.put( "通道3-分系统2-电池簇2" ,68808L);
//        ClusterVolIdMap.put( "通道3-分系统2-电池簇3" ,70617L);
//        ClusterVolIdMap.put( "通道3-分系统2-电池簇4" ,64709L);
//        ClusterVolIdMap.put( "通道3-分系统2-电池簇5" ,65686L);
//        ClusterVolIdMap.put( "通道3-分系统2-电池簇6" ,62126L);
//        ClusterVolIdMap.put( "通道3-分系统2-电池簇7" ,68206L);
//        ClusterVolIdMap.put( "通道3-分系统2-电池簇8" ,65654L);
//        ClusterVolIdMap.put( "通道3-分系统2-电池簇9" ,64998L);
//
//        ClusterVolIdMap.put( "通道4-分系统1-电池簇1" ,62490L);
//        ClusterVolIdMap.put( "通道4-分系统1-电池簇2" ,67089L);
//        ClusterVolIdMap.put( "通道4-分系统1-电池簇3" ,63326L);
//        ClusterVolIdMap.put( "通道4-分系统1-电池簇4" ,61583L);
//        ClusterVolIdMap.put( "通道4-分系统1-电池簇5" ,66805L);
//        ClusterVolIdMap.put( "通道4-分系统1-电池簇6" ,69385L);
//        ClusterVolIdMap.put( "通道4-分系统1-电池簇7" ,69108L);
//        ClusterVolIdMap.put( "通道4-分系统1-电池簇8" ,54864L);
//        ClusterVolIdMap.put( "通道4-分系统1-电池簇9" ,67693L);
//
//        ClusterVolIdMap.put( "通道4-分系统2-电池簇1" ,69989L);
//        ClusterVolIdMap.put( "通道4-分系统2-电池簇2" ,65550L);
//        ClusterVolIdMap.put( "通道4-分系统2-电池簇3" ,67896L);
//        ClusterVolIdMap.put( "通道4-分系统2-电池簇4" ,66953L);
//        ClusterVolIdMap.put( "通道4-分系统2-电池簇5" ,68314L);
//        ClusterVolIdMap.put( "通道4-分系统2-电池簇6" ,66071L);
//        ClusterVolIdMap.put( "通道4-分系统2-电池簇7" ,65969L);
//        ClusterVolIdMap.put( "通道4-分系统2-电池簇8" ,63574L);
//        ClusterVolIdMap.put( "通道4-分系统2-电池簇9" ,68782L);
    }

//    /**
//     * 写入TXT文件
//     */
//    public static void writeFile() {
//        try {
//            File writeName = new File("output.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
//            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
//            try (FileWriter writer = new FileWriter(writeName);
//                 BufferedWriter out = new BufferedWriter(writer)
//            ) {
//                out.write("我会写入文件啦1\r\n"); // \r\n即为换行
//                out.write("我会写入文件啦2\r\n"); // \r\n即为换行
//                out.flush(); // 把缓存区内容压入文件
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
