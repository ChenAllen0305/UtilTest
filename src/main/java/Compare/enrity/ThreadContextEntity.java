package Compare.enrity;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ThreadContextEntity
 * Author: yujianan
 * date: 2019/6/25/025
 * Description: 
*/
public class ThreadContextEntity {
    private static final ThreadLocal<Map<String, Object>> threadContext = new ThreadLocal<>();

    public ThreadContextEntity() {
    }

    public static void clear() {
        Map<String, Object> map = get();
        if (map != null) {
            map.clear();
        }

    }

    public static void set(String key, Object obj) {
        Map<String, Object> map = threadContext.get();
        if (map == null) {
            map = new HashMap<>();
            threadContext.set(map);
        }

        map.put(key, obj);
    }

    public static Object get(String key) {
        Map<String, Object> map = threadContext.get();
        return map == null ? null : map.get(key);
    }

    public static Object remove(String key) {
        Map<String, Object> map = threadContext.get();
        return map == null ? null : map.remove(key);
    }

    public static Map<String, Object> get() {
        return threadContext.get();
    }
}
