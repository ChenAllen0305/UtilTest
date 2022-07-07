package RocketMQTest.pull;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.consumer.store.OffsetStore;
import org.apache.rocketmq.client.exception.MQClientException;

/**
 * @className: GetOffset
 * @author: ChenLun
 * @date: 2022/5/24 10:05
 * @description:
 */
@Slf4j
public class GetOffset {
    public static void main(String[] args) throws MQClientException {
        DefaultLitePullConsumer litePullConsumer = new DefaultLitePullConsumer("test2");
        litePullConsumer.setAutoCommit(Boolean.FALSE);
        litePullConsumer.setNamesrvAddr("10.7.1.60:9876");
        litePullConsumer.start();


        try {
            OffsetStore offsetStore = litePullConsumer.getOffsetStore();
            log.info(offsetStore.toString());
        } finally {
            litePullConsumer.shutdown();
        }
    }
}
