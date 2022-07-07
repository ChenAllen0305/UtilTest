package RocketMQTest;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 * @className: Consumer
 * @author: ChenLun
 * @date: 2022/3/30 9:41
 * @description:
 */
public class Consumer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");

        consumer.setNamesrvAddr("10.7.1.60:9876");

        consumer.subscribe("88_155_101_handle_88_155_101_88_155_000000_6tcuPPZCkCqYX3iS39yFfxnMwjA2CjsHzzbtNokiR2TqfFnyQsxvQN9rKRLvnzPk", "*");
//        consumer.subscribe("88_155_101_handle_88_155_000000_6tcuPPZCkCqYX3iWcQA3DLDHjLspRYjz9DN5aStm5wZR3XnFTFgWa2zZW5rgBN8b", "*");

        consumer.setMessageModel(MessageModel.BROADCASTING);

        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            for (MessageExt msg : msgs) {
                soutSubscribeResult(new String(msg.getBody()));
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        consumer.start();

    }

    private static void soutSubscribeResult(String message) {
        System.out.println("Consumer group1: 销售" + message);
    }
}
