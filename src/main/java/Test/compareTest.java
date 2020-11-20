package Test;

import Util.CompareSetUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class compareTest {
    public static void main(String[] args) {
        //要加判断为null和size>0
        CompareSetUtil csu = new CompareSetUtil();
        Set s1 = new HashSet();
        s1.add(1);
        s1.add(2);
        s1.add(3);

        Set s2 = new HashSet();
        s2.add(2);
        s2.add(3);
        s2.add(4);

        List<Long> list1 = csu.compareAddUtil(s1, s2);
        List<Long> list2 = csu.compareDelUtil(s1, s2);

        System.out.println(list1);
        System.out.println(list2);
    }
}
