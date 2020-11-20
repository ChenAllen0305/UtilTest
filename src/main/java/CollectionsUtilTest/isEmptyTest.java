package CollectionsUtilTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class isEmptyTest {
    public static void main(String[] args) {
        List<Long> l = null;
//        System.out.println(isEmpty(l));
//        System.out.println(isNotEmpty(l));
        List<Long> l2 = null;
//        System.out.println(isEmpty(l2));
//        System.out.println(isNotEmpty(l2));
//        l.add(1L);
//        System.out.println(isEmpty(l));
//        System.out.println(isNotEmpty(l));
        if (isEmpty(l) && isEmpty(l2)) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }

    }

    public static boolean isEmpty(Collection coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isNotEmpty(Collection coll) {
        return !isEmpty(coll);
    }
}
