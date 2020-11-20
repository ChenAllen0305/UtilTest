package WusitaiModel;

import java.io.BufferedReader;
import java.io.FileReader;

public class FinalCreateTemplate {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("E:\\WeChat\\文件\\WeChat Files\\b412303\\FileStorage\\File\\2019-07\\222.txt"));
            reader.readLine();
            String line = null;

            int count = 57340;
            //--------------------------------------
            while((line=reader.readLine())!=null){
                String item[] = line.split(" ");

                String name = item[0];
                String code1 = item[1];
//                String batteryCode1 = "1105011" + code1.substring(7);
                String code2 = item[2];
//                String batteryCode2 = "1105012" + code2.substring(7);
                String code3 = item[3];
//                String batteryCode3 = "1105013" + code3.substring(7);
                String code4 = item[4];
//                String batteryCode4 = "1105014" + code4.substring(7);
                String code5 = item[5];
//                String batteryCode5 = "1105015" + code5.substring(7);
                String code6 = item[6];
//                String batteryCode6 = "1105016" + code6.substring(7);

//                System.out.println(batteryCode1 + "," + batteryCode2 + "," + batteryCode3 + "," + batteryCode4 + ","+batteryCode5 + ","+batteryCode6 + ",");


                // Create MySQL
//                System.out.println("insert into sgool_agc.meas_sjzb(sjid,pid,sfyx,ct) values");
//                System.out.println("(" +count + "," + code6+ ",1,1),");
//                count++;

                if(name.contains("温度")){
                    String battery = code1.substring(8);

                    // Create Temperature Analog
//                    System.out.println("(t"+battery+":Analog{code:"+code6+",name:'"+name+"',title:'"+name+"',pointNumber:1105" +code6+ ",transformRatio:1.0}),");

                    // Create PointDataOf
//                    System.out.println("(t"+battery+")-[:POINTDATATYPE_OF]->(pdt2),");

                    // Create HAS_ANALOG
//                      System.out.println ("-[:HAS_ANALOG]->(t"+battery+")," + "");

                    // SOUT Separator分隔符
                    if(name.contains("96")){
//                        System.out.println("--------");
                    }
                }else{
                    // Create Battery Unit
                    String battery = code1.substring(8);
                    String Bname = name.substring(0,5) + "_" + name.substring(9);
                    String title = name.substring(0,7) + "电池" + name.substring(9);
                    // Battery Code
                    // Change 1~6 for Different Battery Unit
                    String code = "110501" + "1" + code1.substring(7);
                    System.out.println("(b"+battery+":Battery{code:"+code+",name:'"+Bname+"',title:'"+title+"',activity:true}),");

                    // Battery Analog Number satisfies Temperature温度
                    if(Integer.parseInt(name.substring(9)) > 96){
//                        System.out.print("");
                    } else {
                        // Match Part - Battery Unit
//                        System.out.println("(b"+battery+":Battery{code:"+code+"}),");
                        // Create Part - Battery Unit
//                        System.out.println("(b"+battery+")" + "");
                    }
                    // Battery Analog Number satisfies Voltage电压
//                    System.out.println("(b"+battery+":Battery{code:"+code+"}),");
//
                    // Create CONTAINS Relation
                    System.out.println("(pack_B1_1)-[:CONTAINS]->(b"+battery+"),");
//
//
                    // Create Voltage Analog
                    System.out.println("(v"+battery+":Analog{code:"+code1+",name:'"+name+"',title:'"+name+"',pointNumber:1105" +code1+ ",transformRatio:1.0}),");

                    // Create PointDataOf
                    System.out.println("(v"+battery+")-[:POINTDATATYPE_OF]->(pdt1),");

                    // Create HAS_ANALOG Relation
                    System.out.println("(b"+battery+")-[:HAS_ANALOG]->(v"+battery+"),");


                    // SOUT Separator分隔符
                    if(name.contains("288")){
                        System.out.println("-------------------------");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
