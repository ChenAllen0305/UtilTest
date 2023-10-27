package RocketMQClusterTest.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

/**
 * @className: SyncProducer
 * @author: ChenLun
 * @date: 2022/3/30 9:50
 * @description:
 */
@Slf4j
public class SyncProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("defaultProducer");

        producer.setNamesrvAddr("10.7.1.67:9876;10.7.1.69:9876");

        producer.start();

        Message msg = new Message();

        msg.setTopic("LocalTopic");

        msg.setBody(("echo").getBytes(StandardCharsets.UTF_8));

        SendResult result = producer.send(msg);

        log.info("Send Result: " + result);

        producer.shutdown();
    }
}
