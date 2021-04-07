package QueueTest;

import cn.jpush.api.report.UsersResult;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest1 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for (String q : queue) {
            System.out.println(q);
        }
        System.out.println(queue.element());
        System.out.println(queue.peek());
    }
}
