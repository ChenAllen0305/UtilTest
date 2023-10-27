package StringTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: StringListTest
 * @author: ChenLun
 * @date: 2022/9/9 9:32
 * @description:
 */
public class StringListTest {
    public static void main(String[] args) {
        String deleteArea = "浙江省,杭州市,上城区";
        String[] areaConditions = deleteArea.split(",");
        //根据地区删除缓存逻辑
        List<String> salesAreas = new ArrayList<>();
        if (areaConditions.length == 1) {
            salesAreas.add(deleteArea);
        } else if (areaConditions.length == 2) {
            salesAreas.add(deleteArea.substring(0, deleteArea.indexOf(",")));
            salesAreas.add(deleteArea);
        } else if (areaConditions.length == 3) {
            salesAreas.add(deleteArea.substring(0, deleteArea.indexOf(",")));
            salesAreas.add(deleteArea.substring(0, deleteArea.lastIndexOf(",")));
            salesAreas.add(deleteArea);
        }
        System.out.println(salesAreas);
        salesAreas.clear();

        String deleteArea2 = "浙江省,杭州市";
        String[] areaConditions2 = deleteArea2.split(",");
        if (areaConditions2.length == 1) {
            salesAreas.add(deleteArea2);
        } else if (areaConditions2.length == 2) {
            salesAreas.add(deleteArea2.substring(0, deleteArea2.indexOf(",")));
            salesAreas.add(deleteArea2);
        } else if (areaConditions2.length == 3) {
            salesAreas.add(deleteArea2.substring(0, deleteArea2.indexOf(",")));
            salesAreas.add(deleteArea2.substring(0, deleteArea2.lastIndexOf(",")));
            salesAreas.add(deleteArea2);
        }
        System.out.println(salesAreas);
        salesAreas.clear();

        String deleteArea3 = "浙江省";
        String[] areaConditions3 = deleteArea3.split(",");
        if (areaConditions3.length == 1) {
            salesAreas.add(deleteArea3);
        } else if (areaConditions3.length == 2) {
            salesAreas.add(deleteArea3.substring(0, deleteArea3.indexOf(",")));
            salesAreas.add(deleteArea3);
        } else if (areaConditions3.length == 3) {
            salesAreas.add(deleteArea3.substring(0, deleteArea3.indexOf(",")));
            salesAreas.add(deleteArea3.substring(0, deleteArea3.lastIndexOf(",")));
            salesAreas.add(deleteArea3);
        }
        System.out.println(salesAreas);
        salesAreas.clear();
    }
}
