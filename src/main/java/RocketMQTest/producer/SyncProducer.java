package RocketMQTest.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @className: SyncProducer
 * @author: ChenLun
 * @date: 2022/3/30 9:50
 * @description:
 */
@Slf4j
public class SyncProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException,
            RemotingException, InterruptedException {
        // 声明生产者的同时声明其租名
        DefaultMQProducer producer = new DefaultMQProducer("defaultProducer");
        // 设置生产者NameServer地址 - 用户获取Broker集群信息
        producer.setNamesrvAddr("10.7.1.67:9876;10.7.1.69:9876");
        // 设置失败重试次数
        producer.setRetryTimesWhenSendFailed(5);
        // 启动生产者
        producer.start();
        // 创建消息体对象
        Message msg = new Message();
        // 赋值推送Topic
        msg.setTopic("TestTopic");
        // 赋值推送Body
        msg.setBody(("Send Test Message").getBytes(StandardCharsets.UTF_8));
        // 实行推送并输出推送结果
        // 普通推送 - 不指定消息队列
        SendResult result1 = producer.send(msg);
        // 顺序推送 - 指定消息队列
        SendResult result2 = producer.send(msg, new MessageQueueSelector() {
            @Override
            public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                Long id = (Long) arg;
                long index = id % mqs.size();
                return mqs.get((int) index);
            }
        }, 100L);
        // Send Result: SendResult [sendStatus=SEND_OK, msgId=7F0000015B1818B4AAC2886011820000,
        // offsetMsgId=0A07013C00002A9F0000000000226EE2,
        // messageQueue=MessageQueue [topic=TestTopic, brokerName=broker-a, queueId=3], queueOffset=0]
        log.info("Send Result: " + result1);
        log.info("Send Result: " + result2);
        // 关闭生产者
        producer.shutdown();
    }
}
