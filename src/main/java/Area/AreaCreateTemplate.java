package Area;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class AreaCreateTemplate {
    public static int count = 0;
    public static void main(String[] args) {
        try {
//            BufferedReader reader;
//            reader = new BufferedReader(new InputStreamReader(new FileInputStream(("F:\\district-full-xt")),"GBK"));
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(("E:\\2019.11\\export.csv")),"GBK"));
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(("E:\\2019.11\\weather.csv")),"GBK"));
//            reader.readLine();
            String line1 = null;
            String line2 = null;
            Map<String, String> map1 = new HashMap<>();
            Map<String, String> map2 = new HashMap<>();

            //--------------------------------------
            while((line1=reader1.readLine())!=null){
                String item1[] = line1.split(",");

                String provinceCode = item1[0];
                String provinceName = item1[1];
                String cityCode = item1[2];
                String cityName = item1[3];
                String districtCode = item1[4];
                String districtName = item1[5];
//                System.out.println(provinceCode + " " + provinceName + " " + cityCode + " " + cityName + " " + districtCode + " " + districtName);
                String pcd1 = provinceName + " " + cityName + " " + districtName;
                map1.put(pcd1, districtCode);

                while ((line2=reader2.readLine())!=null) {
                    String item2[] = line2.split(",");
                    String weatherCode = item2[0];
                    String provinceName2 = item2[6];
                    String cityName2 = item2[8];
                    String districtName2 = item2[1];
//                    System.out.println(weatherCode + " " + provinceName2 + " " + cityName2 + " " + districtName2);
                    if (provinceName.equals(provinceName2) && cityName.equals(cityName2) && districtName.equals(districtName2)) {
                        System.out.println("match (" + districtName + ":Area{code:" + districtCode + "}) set " + districtName + ".weatherCode=" + weatherCode);
                    }
                    String pcd2 = provinceName2 + " " + cityName2 + " " + districtName2;
                    map2.put(pcd2, weatherCode);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
