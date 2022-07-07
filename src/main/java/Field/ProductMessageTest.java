//package Field;
//
//
//import Util.EmptyUtil;
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//
//import java.lang.reflect.Field;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @className: ProductMessageTEST
// * @author: ChenLun
// * @date: 2022/5/1 9:15
// * @description:
// */
//@Slf4j
//public class ProductMessageTest {
//    public static void main(String[] args) {
//        String message = "{\"handle\":\"88.155.101/yjn20220314002\",\"type\":1,\"templateId\":\"88.155.000000/6tcuPPZCkCqYX3i1w2SyjX5zYeMcYoBmuYAVJsuTYy6w2Z3Spfrhrre2i6Zw2Brp\",\"modelVersionId\":\"1.11.0.1\",\"industryCategory\":null,\"industrySpecific\":null,\"industryTrade\":null,\"industrySubclass\":null,\"details\":[{\"name\":null,\"code\":\"time\",\"value\":\"2\"},{\"name\":null,\"code\":\"address\",\"value\":\"3\"},{\"name\":null,\"code\":\"person\",\"value\":\"4\"},{\"name\":null,\"code\":\"mainHandle\",\"value\":\"5\"},{\"name\":null,\"code\":\"linkData\",\"value\":\"6\"},{\"name\":null,\"code\":\"breakpoint\",\"value\":\"8\"},{\"name\":null,\"code\":\"traceData\",\"value\":\"9\"}]}";
//        MessageBody messageBody = JSON.parseObject(message, MessageBody.class);
//        ProductDO productDO = new ProductDO();
//        List<MessageDetail> details = messageBody.getDetails();
//        if (!EmptyUtil.isEmpty(details)) {
//            Map<String, MessageDetail> fieldValueMap = new HashMap<>(details.size());
//            details.forEach(detail -> fieldValueMap.put(detail.getCode(), detail));
//            Field[] fields = productDO.getClass().getDeclaredFields();
//            Arrays.stream(fields).forEach(field -> {
//                String fieldName = field.getName();
//                MessageDetail fieldMessage = fieldValueMap.get(fieldName);
//                if (!EmptyUtil.isEmpty(fieldMessage)) {
//                    try {
//                        field.set(productDO, fieldMessage.getName());
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
//        log.info(productDO.toString());
//
//    }
//
//}
