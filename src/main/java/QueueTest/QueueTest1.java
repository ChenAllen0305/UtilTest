package QueueTest;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class QueueTest1 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        log.info("size: " + queue.size());

        for (int i = 1; i <= 20; i++) {
            log.info("object:" + queue.poll());
        }
        log.info("size: " + queue.size());
    }
}
