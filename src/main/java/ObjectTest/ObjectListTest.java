package ObjectTest;

import java.util.ArrayList;
import java.util.List;

public class ObjectListTest {
    public static Object getObj(){
//        List<Long> list = new ArrayList<>();
//        list.add(1L);
//        list.add(2L);
//        return list;

        Long[] list = new Long[2];
        list[0] = 1L;
        list[1] = 2L;
        return list;
    }

    public static void main(String[] args) {
        Object obj = getObj();

//        List<Long> result = new ArrayList<>();
        List<Long> result = castList(obj, Long.class);
        System.out.println(result);
    }

    public static <T> List<T> castList(Object obj, Class<T> clazz) {
        List<T> result = new ArrayList<T>();
        if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
                result.add(clazz.cast(o));
            }
            return result;
        } else if (obj instanceof Long[]) {
            Long[] list = (Long[]) obj;
            for (int idx = 0; idx < list.length; idx++) {
                result.add(clazz.cast(list[idx]));
            }
            return result;
        }
        return null;

    }
}
