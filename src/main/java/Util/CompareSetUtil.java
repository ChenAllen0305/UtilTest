package Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CompareSetUtil {
    public List compareAddUtil(Set<Integer> s1, Set<Integer> s2){
        List<Integer> list = new ArrayList<Integer>();
        for(Integer entity : s2){
            if(!s1.contains(entity)){
                list.add(entity);
            }
        }
        return list;
    }

    public List compareDelUtil(Set<Integer> s1, Set<Integer> s2){
        List<Integer> list = new ArrayList<Integer>();
        for(Integer entity : s1){
            if(!s2.contains(entity)){
                list.add(entity);
            }
        }
        return list;
    }
}
