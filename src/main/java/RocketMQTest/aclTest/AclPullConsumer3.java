package RocketMQTest.aclTest;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.consumer.MQPullConsumer;
import org.apache.rocketmq.client.consumer.MQPullConsumerScheduleService;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.apache.rocketmq.remoting.RPCHook;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @className: Consumer
 * @author: ChenLun
 * @date: 2022/3/30 9:41
 * @description:
 */
@Slf4j
public class AclPullConsumer3 {

    public static void main(String[] args) throws MQClientException {
        MQPullConsumerScheduleService scheduleService = new MQPullConsumerScheduleService("pullGroup1");

        scheduleService.getDefaultMQPullConsumer().setNamesrvAddr("localhost:9876");

        scheduleService.setMessageModel(MessageModel.BROADCASTING);

        scheduleService.registerPullTaskCallback("first-topic", (mq, context) -> {
            Random random = new Random();
            double v1 = random.nextDouble();
            log.info("pull start" + v1 + "time:" + new Date());
            MQPullConsumer consumer = context.getPullConsumer();

            try {
                long offset = consumer.fetchConsumeOffset(mq, false);
                if (offset < 0) {
                    offset = 0;
                }

                PullResult pullResult = consumer.pullBlockIfNotFound(mq, null, offset, 10);

                switch (pullResult.getPullStatus()) {
                    case FOUND:
                        List<MessageExt> messageExtList = pullResult.getMsgFoundList();
                        messageExtList.forEach(messageExt -> log.info(new String(messageExt.getBody())));
                        break;
                    case NO_MATCHED_MSG:
                        log.info("NO_MATCHED_MSG" + v1 + "time:" + new Date());
                        break;
                    case NO_NEW_MSG:
                        log.info("NO_NEW_MSG" + v1 + "time:" + new Date());
                        break;
                    case OFFSET_ILLEGAL:
                        log.info("OFFSET_ILLEGAL" + v1 + "time:" + new Date());
                        break;
                    default:
                        break;
                }

                consumer.updateConsumeOffset(mq, pullResult.getNextBeginOffset());
                context.setPullNextDelayTimeMillis(5000);
            } catch (MQClientException e) {
                e.printStackTrace();
            } catch (MQBrokerException e) {
                e.printStackTrace();
            } catch (RemotingException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        scheduleService.registerPullTaskCallback("second-topic", (mq, context) -> {
            Random random = new Random();
            double v1 = random.nextDouble();
            log.info("pull start" + v1 + "time:" + new Date());
            MQPullConsumer consumer = context.getPullConsumer();

            try {
                long offset = consumer.fetchConsumeOffset(mq, false);
                if (offset < 0) {
                    offset = 0;
                }

                PullResult pullResult = consumer.pullBlockIfNotFound(mq, null, offset, 10);

                switch (pullResult.getPullStatus()) {
                    case FOUND:
                        List<MessageExt> messageExtList = pullResult.getMsgFoundList();
                        messageExtList.forEach(messageExt -> log.info(new String(messageExt.getBody())));
                        break;
                    case NO_MATCHED_MSG:
                        log.info("NO_MATCHED_MSG" + v1 + "time:" + new Date());
                        break;
                    case NO_NEW_MSG:
                        log.info("NO_NEW_MSG" + v1 + "time:" + new Date());
                        break;
                    case OFFSET_ILLEGAL:
                        log.info("OFFSET_ILLEGAL" + v1 + "time:" + new Date());
                        break;
                    default:
                        break;
                }

                consumer.updateConsumeOffset(mq, pullResult.getNextBeginOffset());
                context.setPullNextDelayTimeMillis(5000);
            } catch (MQClientException e) {
                e.printStackTrace();
            } catch (MQBrokerException e) {
                e.printStackTrace();
            } catch (RemotingException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        scheduleService.start();
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
