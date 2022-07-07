package RocketMQTest.producer;

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
public class SyncProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("defaultProducer");

        producer.setNamesrvAddr("10.7.1.60:9876");

        producer.start();

        for (int i = 0; i < 4; i++) {
            Message msg = new Message();

            msg.setTopic("TopicTest");

            msg.setBody(("First Send Message: " + i).getBytes(StandardCharsets.UTF_8));


            SendResult result = producer.send(msg);

            System.out.println("First Send Result: " + result);

//            if (i / 2 == 0) {
//                msg.setTopic("second-topic");
//
//                msg.setBody(("Second Send Message " + i).getBytes(StandardCharsets.UTF_8));
//
//                result = producer.send(msg);
//
//                System.out.println("Second Send Result: " + result);
//            }
//
//            if (i / 3 == 0) {
//                msg.setTopic("third-topic");
//
//                msg.setBody(("Third Send Message " + i).getBytes(StandardCharsets.UTF_8));
//
//                result = producer.send(msg);
//
//                System.out.println("Second Send Result: " + result);
//            }
//
//            TimeUnit.SECONDS.sleep(2);
        }

        producer.shutdown();
    }
}
