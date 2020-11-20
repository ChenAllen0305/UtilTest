package WusitaiModel;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ReadDataTest {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("E:\\WeChat\\文件\\WeChat Files\\b412303\\FileStorage\\File\\2019-07\\222.txt"));
            reader.readLine();
            String line = null;
            Map<Integer, Map<String, String>> AllMap = new HashMap<>();
            HashMap<String, String> hmap1 = new HashMap();
//            Map<String, String> map1 = new HashMap<>();
//            Map<String, String> map2 = new HashMap<>();
//            Map<String, String> map3 = new HashMap<>();
//            Map<String, String> map4 = new HashMap<>();
//            Map<String, String> map5 = new HashMap<>();
//            Map<String, String> map6 = new HashMap<>();

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

                hmap1.put(name, code1);
//                map1.put(name, code1);
//                map2.put(name, code2);
//                map3.put(name, code3);
//                map4.put(name, code4);
//                map5.put(name, code5);
//                map6.put(name, code6);

//                int value = Integer.parseInt(last);//如果是数值，可以转化为数值
//                System.out.println(start);
            }
            //-------------------------------------
            // 读取数据
//            System.out.println(map1);
            // 获取集合中的项目
            Set set = hmap1.entrySet();

            // 获得迭代器
            Iterator i = set.iterator();

            // 打印显示元素的值
            while (i.hasNext()) {
                Map.Entry me = (Map.Entry) i.next();
                System.out.print(me.getKey() + ": ");
                System.out.println(me.getValue());
            }
            System.out.println(hmap1.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}