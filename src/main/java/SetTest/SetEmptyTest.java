package SetTest;

import Util.EmptyUtil;

import java.util.*;

/**
 * @className: SetEmptyTest
 * @author: ChenLun
 * @date: 2022/4/12 19:48
 * @description:
 */
public class SetEmptyTest {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        Set<String> set = new HashSet<>(list1);

        System.out.println(EmptyUtil.isEmpty(set));

        List<String> list2 = Arrays.asList("1", "2");
        set.addAll(list2);
        System.out.println(EmptyUtil.isEmpty(set));

        Set<String> emptySet = new HashSet<>();
        System.out.println(new ArrayList<>(emptySet));
    }
}
