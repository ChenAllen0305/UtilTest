package RocketMQClusterTest.consumer;

import Util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.apache.rocketmq.remoting.RPCHook;

import java.util.Date;

/**
 * @className: Consumer
 * @author: ChenLun
 * @date: 2022/3/30 9:41
 * @description:
 */
@Slf4j
public class AclConsumer1 {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1", getNormalAclHook(), new AllocateMessageQueueAveragely());

        consumer.setNamesrvAddr("10.7.1.67:9876;10.7.1.69:9876");

        consumer.subscribe("LocalTopic", "*");

        consumer.setMessageModel(MessageModel.BROADCASTING);

        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);

        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            for (MessageExt msg : msgs) {
                String message = new String(msg.getBody());
                log.info("messageId: " + msg.getMsgId() + ", message: " + message + ", " + DateUtils.format(new Date()));
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        consumer.start();

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
        return new AclClientRPCHook(new SessionCredentials("test-cl", "12345678"));
    }
}
