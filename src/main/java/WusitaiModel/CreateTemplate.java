package WusitaiModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CreateTemplate {
    public static int count = 0;
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("E:\\WeChat\\文件\\WeChat Files\\b412303\\FileStorage\\File\\2019-07\\222.txt"));
            reader.readLine();
            String line = null;
            Map<Integer, Map<String, String>> AllMap = new HashMap<>();
            HashMap<String, String> hmap1 = new HashMap();

            int count = 57340;

            //--------------------------------------
            // 保存数据到Map中
            while((line=reader.readLine())!=null){
                String item[] = line.split(" ");

                String name = item[0];
                String code1 = item[1];
                String code2 = item[2];
                String code3 = item[3];
                String code4 = item[4];
                String code5 = item[5];
                String code6 = item[6];

                System.out.println("("+count+",1105"+code6+",1,1),");
                count++;

//                System.out.println(code1.substring(6) + ",");
//                String sub = code1.substring(6);
//                String code = "110501" + sub;

                //Analog
//                System.out.println("(a" + code1 + ":Analog{code:" + code1 + ",NAME:'" + name + "',title:'" + name +
//                        "',pointNumber:" + code1 + ",transformRatio:10}),");
//                System.out.println("(a" + code2 + ":Analog{code:" + code2 + ",NAME:'" + name + "',title:'" + name +
//                        "',pointNumber:" + code2 + ",transformRatio:1.0}),");
//                System.out.println("(a" + code3 + ":Analog{code:" + code3 + ",NAME:'" + name + "',title:'" + name +
//                        "',pointNumber:" + code3 + ",transformRatio:1.0}),");
//                System.out.println("(a" + code4 + ":Analog{code:" + code4 + ",NAME:'" + name + "',title:'" + name +
//                        "',pointNumber:" + code4 + ",transformRatio:1.0}),");
//                System.out.println("(a" + code5 + ":Analog{code:" + code5 + ",NAME:'" + name + "',title:'" + name +
//                        "',pointNumber:" + code5 + ",transformRatio:1.0}),");
//                System.out.println("(a" + code6 + ":Analog{code:" + code6 + ",NAME:'" + name + "',title:'" + name +
//                        "',pointNumber:" + code6 + ",transformRatio:1.0}),");
                //Has_Analog
//                System.out.println("(pack_a1_1)-[:HAS_ANALOG]->(a"+code1 + "), ");

                //Create battery
                if(name.contains("温度")){
                    System.out.print("");
//                    System.out.println("(b:Battery{code:}),(t"+code1.substring(8)+":Analog{code:" + code1 + "}),");
//                    System.out.println("(b)-[:HAS_ANALOG]->(t"+code1.substring(8)+"),");
                }else{
                    //create battery unit
//                    String title = name.substring(0,7)+"电池"+code6.substring(8);
//                    System.out.println("(b"+code6+":Battery{code:"+code6+",name:'"+code6+"',title:'"+title+"',activity:true}),");
//                    System.out.println("(pack_B2_2)-[:CONTAINS]->(b"+code6+"),");

                    //create HAS_ANALOG
//                    System.out.println("(b"+code6.substring(8)+":Battery{code:" + code6 + "}),(a"+code6.substring(8)+":Analog{code:" + code6 + "}),");
//                    System.out.println("(b"+code6.substring(8)+")-[:HAS_ANALOG]->(a"+code6.substring(8)+"),");

                    //Top 96 code
//                    int sub = Integer.parseInt(name.substring(9));
//                    if(sub <= 96){
//                        System.out.println(code6 + "");
//                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
