package Test;

import java.util.ArrayList;
import java.util.List;

public class subListTest {
    public static void main(String[] args) {
        List<String> sourceList = new ArrayList<String>(){{
            add("H");
            add("O");
            add("L");
            add("L");
            add("I");
            add("S");
        }};

        List subList = sourceList.subList(2, 5);

        System.out.println("sourceList: " + sourceList);
        System.out.println("subList: " + subList);

        // 如果修改subList中的属性，原List中属性也会更改,反之亦然
//        subList.set(2, "666");
        sourceList.set(2, "AA");
//
//        System.out.println("sourceList: " + sourceList);
//        System.out.println("subList: " + subList);

        //向subList中添加也会改变sourceList中的属性
//        subList.add("125");

        //如果向sourceList中添加元素，则会抛出异常
//        sourceList.add("122");

        System.out.println("sourceList: " + sourceList);
        System.out.println("subList: " + subList);
    }
}
