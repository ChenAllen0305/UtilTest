package RocketMQTest.aclTest;

import Util.EmptyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.RPCHook;

import java.util.List;

/**
 * @className: Consumer
 * @author: ChenLun
 * @date: 2022/3/30 9:41
 * @description:
 */
@Slf4j
public class LitePullConsumer {

    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultLitePullConsumer litePullConsumer = new DefaultLitePullConsumer("lite1", getNormalAclHook());

        litePullConsumer.setNamesrvAddr("localhost:9876");

        litePullConsumer.subscribe("first-topic", "*");
//        litePullConsumer.subscribe("second-topic", "*");

        litePullConsumer.start();

        List<MessageExt> messageExts = litePullConsumer.poll();
        if (!EmptyUtil.isEmpty(messageExts)) {
            messageExts.forEach(message -> {
                String messageStr = new String(message.getBody());
                log.info(messageStr);
            });
        }


//        log.info("sleep");
//        Thread.sleep(10000);
//
//        log.info("sub second-topic");
//        litePullConsumer.unsubscribe("first-topic");
//        litePullConsumer.subscribe("second-topic", "*");

        log.info("start again");
        litePullConsumer.unsubscribe("first-topic");
        List<MessageExt> messageExts2 = litePullConsumer.poll();
        if (!EmptyUtil.isEmpty(messageExts2)) {
            messageExts2.forEach(message -> {
                String messageStr = new String("again : " + message.getBody());
                log.info(messageStr);
            });
        }
//
//        log.info("sleep");
//        Thread.sleep(10000);
//
//        log.info("unsub first-topic");
//        litePullConsumer.unsubscribe("first-topic");
//        List<MessageExt> messageExts3 = litePullConsumer.poll();
//        if (!EmptyUtil.isEmpty(messageExts3)) {
//            messageExts3.forEach(message -> {
//                String messageStr = new String(message.getBody());
//                log.info(messageStr);
//                litePullConsumer.commitSync();
//            });
//        }
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
