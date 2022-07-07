package JsonParse;

import com.alibaba.fastjson.JSONObject;

/**
 * @className: JsonToStringTest
 * @author: ChenLun
 * @date: 2022/5/9 18:55
 * @description:
 */
public class JsonToStringTest {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("marketTime", "2022-02-02");
        jsonObject.put("specs", "1*3*2");
        jsonObject.put("price", "1.6");
        jsonObject.put("boms", "[\n" +
                "    {\n" +
                "        \"name\": \"zhh测试_零件1\",\n" +
                "        \"code\": \"testcode1\",\n" +
                "        \"quantity\": 2,\n" +
                "        \"unit\": \"个\",\n" +
                "        \"specs\": \"1*1*1\",\n" +
                "        \"childrenMaterial\": [],\n" +
                "        \"priceInfos\": [\n" +
                "            {\n" +
                "                \"supplier\": \"zhh供应商1\",\n" +
                "                \"templateId\": \"xxxx\",\n" +
                "                \"price\": 16.66,\n" +
                "                \"tenantCode\":\"xxxx\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"industryCategory\": \"文化、体育和娱乐业\",\n" +
                "        \"industrySpecific\": \"新闻和出版业\",\n" +
                "        \"industryTrade\": \"民间新闻\",\n" +
                "        \"industrySubclass\": \"新闻\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"zhh测试_零件2\",\n" +
                "        \"code\": \"testcode2\",\n" +
                "        \"quantity\": 2,\n" +
                "        \"unit\": \"个\",\n" +
                "        \"specs\": \"1*1*1\",\n" +
                "        \"childrenMaterial\": [\n" +
                "            {\n" +
                "                \"name\": \"zhh测试_零件3\",\n" +
                "                \"code\": \"testcode3\",\n" +
                "                \"quantity\": 3,\n" +
                "                \"unit\": \"个\",\n" +
                "                \"specs\": \"3*3*3\",\n" +
                "                \"childrenMaterial\": [],\n" +
                "                \"priceInfos\": [\n" +
                "                    {\n" +
                "                        \"supplier\": \"zhh供应商2\",\n" +
                "                        \"templateId\": null,\n" +
                "                        \"price\": 22.22\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"supplier\": \"zhh供应商3\",\n" +
                "                        \"templateId\": null,\n" +
                "                        \"price\": 11.11\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"industryCategory\": \"文化、体育和娱乐业\",\n" +
                "                \"industrySpecific\": \"新闻和出版业\",\n" +
                "                \"industryTrade\": \"民间新闻\",\n" +
                "                \"industrySubclass\": \"新闻\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"priceInfos\": [\n" +
                "            {\n" +
                "                \"supplier\": \"test供应商1\",\n" +
                "                \"templateId\": null,\n" +
                "                \"price\": 16.66,\n" +
                "                \"healthStatus\": 2,\n" +
                "                \"checkInfo\": \"该企业不是合作关系\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"supplier\": \"test供应商2\",\n" +
                "                \"templateId\": null,\n" +
                "                \"price\": 18.88,\n" +
                "                \"healthStatus\": 2,\n" +
                "                \"checkInfo\": null\n" +
                "            }\n" +
                "        ],\n" +
                "        \"industryCategory\": \"文化、体育和娱乐业\",\n" +
                "        \"industrySpecific\": \"新闻和出版业\",\n" +
                "        \"industryTrade\": \"民间新闻\",\n" +
                "        \"industrySubclass\": \"新闻\"\n" +
                "    }\n" +
                "]");

        System.out.println(jsonObject.toJSONString());
    }
}
