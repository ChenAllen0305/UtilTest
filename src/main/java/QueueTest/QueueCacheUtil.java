package QueueTest;

import Util.EmptyUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: QueueCacheUtil
 * Author: ChenLun
 * date: 2021/10/9
 * Description:
 */
public class QueueCacheUtil {

    private static final Queue<Integer> queue = new LinkedList<>();

    public static void setData(Integer Integer) {
        queue.add(Integer);
    }

    public static void insert(Queue<Integer> IntegerS) {
        synchronized (queue) {
            queue.addAll(IntegerS);
        }
    }

    public static synchronized List<Integer> getTop(Integer number) {
        synchronized (queue) {
            List<Integer> results = new ArrayList<>();
            for (int i = 1; i <= number; i++) {
                Integer integer = queue.poll();
                if (EmptyUtil.isEmpty(integer)) {
                    return results;
                }
                results.add(integer);
            }
            return results;
        }
    }

    public static Integer getSize() {
        return queue.size();
    }
}
