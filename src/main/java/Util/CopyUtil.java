package Util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: CopyUtil
 * Author: yujianan
 * date: 2019/9/9/009
 * Description: 属性拷贝工具类
 */
@Slf4j
public class CopyUtil {

    /**
     * 对象拷贝方法
     *
     * @param src      源对象
     * @param destType 目标对象类型
     * @param <T>      泛型
     * @return 目标对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T objectCopy(Object src, Class destType) {
        T dest = null;
        try {
            dest = (T) destType.newInstance();
            BeanUtils.copyProperties(src, dest);
        } catch (Exception e) {
            log.error("对象拷贝失败，{}", e.getMessage());
        }
        return dest;
    }

    /**
     * 对象属性拷贝方法
     *
     * @param <T>      泛型
     * @param srcList  源对象列表
     * @param destType 目标类
     * @return 目标对象列表
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> listCopy(List<?> srcList, Class<T> destType) {
        if (srcList.isEmpty()) {
            return null;
        }
        List destList = new ArrayList();
        try {
            for (Object src : srcList) {
                T dest = destType.newInstance();
                BeanUtils.copyProperties(src, dest);
                destList.add(dest);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            log.error("对象拷贝失败，{}", e.getMessage());
        }
        return destList;
    }

}
