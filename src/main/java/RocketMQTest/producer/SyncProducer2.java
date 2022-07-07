package RocketMQTest.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @className: SyncProducer
 * @author: ChenLun
 * @date: 2022/3/30 9:50
 * @description:
 */
@Slf4j
public class SyncProducer2 {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("producer2");

        producer.setNamesrvAddr("118.112.187.220:19888");
        

        producer.start();

        for (int i = 0; i < 4; i++) {
            Message msg = new Message();

            msg.setTopic("88_155_101_88_155_000000_6tcuPPZCkCqYX3");

            msg.setBody(("test message").getBytes(StandardCharsets.UTF_8));

            SendResult result = producer.send(msg);

            log.info("First Send Result: " + result);

            TimeUnit.SECONDS.sleep(2);
        }

        producer.shutdown();
    }
}
