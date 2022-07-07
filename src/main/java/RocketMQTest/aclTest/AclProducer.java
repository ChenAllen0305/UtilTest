package RocketMQTest.aclTest;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.RPCHook;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @className: SyncProducer
 * @author: ChenLun
 * @date: 2022/3/30 9:50
 * @description:
 */
@Slf4j
public class AclProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("groupA", getLocalAclHook());

        producer.setNamesrvAddr("localhost:9876");

        producer.setRetryTimesWhenSendFailed(5);

        producer.start();

        String time = ", time: " + (new Date()).getTime();

        try {
            Message msg = new Message();

//            msg.setTopic("%RETRY%group1");
//            msg.setBody(("topicA: 3333333 + " + time).getBytes(StandardCharsets.UTF_8));
//            SendResult result1 = producer.send(msg, 5000L);
//            log.info("result1: " + result1);

            msg.setTopic("topicB1");
            msg.setBody(("topicB: " + time).getBytes(StandardCharsets.UTF_8));
            SendResult result2 = producer.send(msg, 5000L);
            log.info("result2: " + result2);
        } finally {
            producer.shutdown();
        }
    }

    /**
     * admin
     *
     * @return
     */
    private static RPCHook getAclHook() {
        return new AclClientRPCHook(new SessionCredentials("rocketmq2", "12345678"));
    }

    /**
     * 普通账号
     *
     * @return
     */
    private static RPCHook getNormalAclHook() {
        return new AclClientRPCHook(new SessionCredentials("RocketMQ", "12345678"));
    }

    private static RPCHook getLocalAclHook() {
        return new AclClientRPCHook(new SessionCredentials("test-cl", "12345678"));
    }
}
