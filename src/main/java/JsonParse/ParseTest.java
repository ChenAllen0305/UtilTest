package JsonParse;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ClassName: ParseTest
 * Author: ChenLun
 * date: 2021/9/9
 * Description:
 */
public class ParseTest {
    public static void main(String[] args) {
        List<BarcodeAttrsEntity> goodsData = JSON.parseArray("[\n" +
                "        {\n" +
                "          \"attrName\": \"平台标识\",\n" +
                "          \"attrCode\": \"platformFlag\",\n" +
                "          \"attrValue\": \"拼多多\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"平台订单号\",\n" +
                "          \"attrCode\": \"platformCode\",\n" +
                "          \"attrValue\": \"210913-609264670120881\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"管易发货单号\",\n" +
                "          \"attrCode\": \"code\",\n" +
                "          \"attrValue\": \"SDO381023385332\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"店铺名称\",\n" +
                "          \"attrCode\": \"shopName\",\n" +
                "          \"attrValue\": \"拼多多禧天龙专卖店\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"收货人\",\n" +
                "          \"attrCode\": \"receiverName\",\n" +
                "          \"attrValue\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"收货人手机号\",\n" +
                "          \"attrCode\": \"receiverMobile\",\n" +
                "          \"attrValue\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"收货地址\",\n" +
                "          \"attrCode\": \"receiverAddress\",\n" +
                "          \"attrValue\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"省(收货人)\",\n" +
                "          \"attrCode\": \"province\",\n" +
                "          \"attrValue\": \"安徽省\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"市(收货人)\",\n" +
                "          \"attrCode\": \"city\",\n" +
                "          \"attrValue\": \"宿州市\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"区县(收货人)\",\n" +
                "          \"attrCode\": \"district\",\n" +
                "          \"attrValue\": \"泗县\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"省(发货人)\",\n" +
                "          \"attrCode\": \"provinceSend\",\n" +
                "          \"attrValue\": \"天津\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"市(发货人)\",\n" +
                "          \"attrCode\": \"citySend\",\n" +
                "          \"attrValue\": \"天津市\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"区县(发货人)\",\n" +
                "          \"attrCode\": \"districtSend\",\n" +
                "          \"attrValue\": \"滨海新区高新区\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"寄件人\",\n" +
                "          \"attrCode\": \"senderName\",\n" +
                "          \"attrValue\": \"拼多多禧天龙专卖店\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"寄件人地址\",\n" +
                "          \"attrCode\": \"senderAddress\",\n" +
                "          \"attrValue\": \"风光大道12号\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"寄件人电话\",\n" +
                "          \"attrCode\": \"senderMobile\",\n" +
                "          \"attrValue\": \"022-12345678\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"管易订单号\",\n" +
                "          \"attrCode\": \"tradeCode\",\n" +
                "          \"attrValue\": \"SO380975492479\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"订单类型\",\n" +
                "          \"attrCode\": \"orderType\",\n" +
                "          \"attrValue\": \"SALES\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"物流公司\",\n" +
                "          \"attrCode\": \"expressName\",\n" +
                "          \"attrValue\": \"德邦快递拼多多\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"物流单号\",\n" +
                "          \"attrCode\": \"expressNo\",\n" +
                "          \"attrValue\": \"DPK368003231617\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"订单备注\",\n" +
                "          \"attrCode\": \"sellerMemo\",\n" +
                "          \"attrValue\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"销售凭证\",\n" +
                "          \"attrCode\": \"vbelnVa\",\n" +
                "          \"attrValue\": \"1000468620\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"交货单号\",\n" +
                "          \"attrCode\": \"vbelnVl\",\n" +
                "          \"attrValue\": \"8000479118\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"库存地点\",\n" +
                "          \"attrCode\": \"lgort\",\n" +
                "          \"attrValue\": \"1018\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attrName\": \"商品信息\",\n" +
                "          \"attrCode\": \"materials\",\n" +
                "          \"attrValue\": \"[{\\\"materialName\\\":\\\"5022五层高透烟熏灰抽屉瓷白框\\\",\\\"number\\\":\\\"1\\\"}]\"\n" +
                "        }\n" +
                "      ]", BarcodeAttrsEntity.class);
        Map<String, BarcodeAttrsEntity> atttrMap = goodsData.stream().collect(Collectors.toMap
                (BarcodeAttrsEntity::getAttrCode, o1 -> o1, (k1, k2) -> k1));
        for (Map.Entry<String, BarcodeAttrsEntity> entry : atttrMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
