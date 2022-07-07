package Util;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: EmptyUtil
 * Author: yujianan
 * date: 2019/6/13/013
 * Description:
 */
public class EmptyUtil {
    private EmptyUtil() {
    }

    /**
     * 用于判断一个对象是否为空值对象 支持判断非集合框架中的简单对象，集合框架，map。
     *
     * @param object 判定对象
     * @return 是否为空
     */
    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }

        if (object instanceof String && "".equals((object + "").trim())) {
            return true;
        }

        if (object instanceof List && ((List) object).isEmpty()) {
            return true;
        }

        if (object instanceof Set && ((Set) object).isEmpty()) {
            return true;
        }

        if (object instanceof Map && ((Map) object).size() == 0) {
            return true;
        }

        return false;
    }
}
