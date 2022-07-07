package RocketMQTest.pull;

import Util.EmptyUtil;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @className: Consumer
 * @author: ChenLun
 * @date: 2022/3/30 9:41
 * @description:
 */
public class PullAssignConsumer {

    public static void main(String[] args) throws MQClientException {
        DefaultLitePullConsumer litePullConsumer = new DefaultLitePullConsumer("test1");
        litePullConsumer.setAutoCommit(Boolean.FALSE);
        litePullConsumer.setNamesrvAddr("10.7.1.60:9876");
        litePullConsumer.start();

        Collection<MessageQueue> mqset = litePullConsumer.fetchMessageQueues("55_188_101_handle_88_155_101_testData");
        List<MessageQueue> messageQueues = new ArrayList<>(mqset);

        
        litePullConsumer.assign(messageQueues);
        litePullConsumer.seekToEnd(messageQueues.get(0));
        try {
            List<MessageExt> messageExts = litePullConsumer.poll();
            if (!EmptyUtil.isEmpty(messageExts)) {
                messageExts.forEach(message -> {
                    soutSubscribeResult(message);
                    litePullConsumer.commitSync();
                });
            }
        } finally {
            litePullConsumer.shutdown();
        }
    }

    private static void soutSubscribeResult(MessageExt message) {
        System.out.println("Consumer group1: " + new String(message.getBody()));
    }

    private static void soutSubscribeResult(String message) {
        System.out.println("Consumer group1: " + message);
    }
}
