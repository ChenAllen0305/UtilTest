package SetTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetToList {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
        List<Integer> list = new ArrayList<>(set);
        for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
