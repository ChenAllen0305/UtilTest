package RocketMQTest.aclTest;

import Util.EmptyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.RPCHook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @className: Consumer
 * @author: ChenLun
 * @date: 2022/3/30 9:41
 * @description:
 */
@Slf4j
public class AclPullConsumer2 {

    public static void main(String[] args) throws MQClientException {
        DefaultLitePullConsumer litePullConsumer = new DefaultLitePullConsumer("group1", getNormalAclHook());

        litePullConsumer.setNamesrvAddr("localhost:9876");

        String topic = "first-topic";

        litePullConsumer.setAutoCommit(Boolean.FALSE);

        litePullConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);

        litePullConsumer.start();
        log.info("pull consumer start");
        Collection<MessageQueue> mqset = null;
        try {
            log.info("get message queue");
            mqset = litePullConsumer.fetchMessageQueues(topic);
        } catch (Exception e) {
            log.info("队列中无topic为" + topic + "的消息队列");
        }

        if (!EmptyUtil.isEmpty(mqset)) {
            List<MessageQueue> messageQueues = new ArrayList<>(mqset);
            litePullConsumer.assign(messageQueues);
            litePullConsumer.seekToEnd(messageQueues.get(0));
            List<MessageExt> messageExts = litePullConsumer.poll();
            if (!EmptyUtil.isEmpty(messageExts)) {
                messageExts.forEach(message -> {
                    String messageStr = new String(message.getBody());
                    log.info(messageStr);
                    litePullConsumer.commitSync();
                });
            }
        } else {
            log.info("no message");
        }
    }

    private static void soutSubscribeResult(String message) {
        System.out.println("Consumer group1: 销售" + message);
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
