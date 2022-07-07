package RocketMQTest.aclTest;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.RPCHook;

/**
 * @className: Consumer
 * @author: ChenLun
 * @date: 2022/3/30 9:41
 * @description:
 */
@Slf4j
public class AclPushConsumer5 {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group5", getAdminAclHook(), new AllocateMessageQueueAveragely());

        consumer.setNamesrvAddr("localhost:9876");

        consumer.subscribe("topicA", "*");
        consumer.subscribe("topicB", "*");

//        consumer.setConsumeMessageBatchMaxSize(10);

//        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            for (MessageExt msg : msgs) {
                String message = new String(msg.getBody());
//                if (message.equals("restart")) {
//                    log.info("do restart");
//                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
//                } else {
//                    log.info(message);
//                }
                log.info(message);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        consumer.start();

    }

    private static void soutSubscribeResult(String message) {
        log.info("Consumer group1: 销售" + message);
    }

    /**
     * admin
     *
     * @return
     */
    private static RPCHook getAdminAclHook() {
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
}
