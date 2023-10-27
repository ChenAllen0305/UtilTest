package RocketMQTest.orderly;

import Util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.RPCHook;

import java.util.Date;

/**
 * @className: Consumer
 * @author: ChenLun
 * @date: 2022/3/30 9:41
 * @description:
 */
@Slf4j
public class OrderPushConsumer2 {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("orderGroup2");

        consumer.setNamesrvAddr("10.0.0.23:9876");

//        consumer.setMessageModel(MessageModel.BROADCASTING);

        consumer.subscribe("orderTopic", "*");

        consumer.setSuspendCurrentQueueTimeMillis(10000);

        consumer.registerMessageListener((MessageListenerOrderly) (msgs, context) -> {
            for (MessageExt msg : msgs) {
                String message = new String(msg.getBody());
                log.info("messageId: " + msg.getMsgId() + ", message: " + message + " " + DateUtils.format(new Date()));
                try {
                    int i = 1 / 0;
                } catch (Exception e) {
                    log.error("异常重试" + msg.getTopic() + " " + msg.getReconsumeTimes() + " " + DateUtils.format(new Date()));
                    if (msg.getReconsumeTimes() >= 5) {
                        return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                    } else {
                        return ConsumeOrderlyStatus.SUCCESS;
                    }
                }
            }
            return ConsumeOrderlyStatus.SUCCESS;
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
        return new AclClientRPCHook(new SessionCredentials("test-cl", "12345678"));
    }
}
