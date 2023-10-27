package RocketMQTest;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class Consumer2 {

    public static void main(String[] args) throws MQClientException {
        // 声明消费者的同时声明其组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("TestGroup");
        // 设置消费者NameServer地址 - 用于获取Broker集群信息
        consumer.setNamesrvAddr("10.7.1.67:9876;10.7.1.69:9876");
        // 设置订阅Topic
        consumer.subscribe("TestTopic", "*");
        // 设置消息模型 - 此处使用广播模式
        consumer.setMessageModel(MessageModel.BROADCASTING);
        // 设置监听方法
        consumer.registerMessageListener(getListener());
        // 启动消费者
        consumer.start();
    }

    public static MessageListenerConcurrently getListener() {
        return (list, consumeConcurrentlyContext) -> {
            for (MessageExt msg : list) {
                // 获取消息对象
                String message = new String(msg.getBody());
                if (message.contains("33333")) {
                    log.info("getReconsumeTimes" + msg.getReconsumeTimes());
                    // 获取重试次数
                    if (msg.getReconsumeTimes() < 5) {
                        // 返回待重试状态
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    } else {
                        // 避免重试太多次，返回消费成功状态
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }
                }
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        };
    }
}
