package RocketMQTest.pull;

import Util.EmptyUtil;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @className: Consumer
 * @author: ChenLun
 * @date: 2022/3/30 9:41
 * @description:
 */
public class PullSubscribeConsumer {

    public static void main(String[] args) throws MQClientException {
        DefaultLitePullConsumer litePullConsumer = new DefaultLitePullConsumer("test1");
        litePullConsumer.setAutoCommit(Boolean.TRUE);
        litePullConsumer.setNamesrvAddr("10.7.1.60:9876");
        litePullConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        litePullConsumer.subscribe("55_188_101_handle_88_155_101_testData2", "*");
        litePullConsumer.start();
        try {
            List<MessageExt> messageExts = litePullConsumer.poll();
            if (!EmptyUtil.isEmpty(messageExts)) {
                messageExts.forEach(message -> soutSubscribeResult(message));
            }
        } finally {
            litePullConsumer.shutdown();
        }
    }

    private static void soutSubscribeResult(MessageExt message) {
        System.out.println("Consumer group1: " + message);
        System.out.println(new String(message.getBody()));
    }

    private static void soutSubscribeResult(String message) {
        System.out.println("Consumer group1: " + message);
    }
}
