package CopyUtilTest;

import Util.CopyUtil;
import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * ClassName: CopyUtilTest
 * Author: ChenLun
 * date: 2021/9/13
 * Description:
 */
public class CopyUtilTest {
    public static void main(String[] args) {
        List<BarcodeRegisterValueVO> attrs = JSONArray.parseArray("[\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"米家商城\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2000,\n" +
                        "            \"type\": \"platformFlag\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"4210909379106551\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2001,\n" +
                        "            \"type\": \"platformCode\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"小米有品\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2002,\n" +
                        "            \"type\": \"shopName\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2003,\n" +
                        "            \"type\": \"receiverAddress\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"浙江省\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2004,\n" +
                        "            \"type\": \"province\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"杭州市\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2005,\n" +
                        "            \"type\": \"city\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"江干区\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2006,\n" +
                        "            \"type\": \"district\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"天津\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2007,\n" +
                        "            \"type\": \"provinceSend\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"天津市\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2008,\n" +
                        "            \"type\": \"citySend\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"滨海新区高新区\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2009,\n" +
                        "            \"type\": \"districtSend\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"小米有品\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2010,\n" +
                        "            \"type\": \"senderName\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"风光大道12号\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2011,\n" +
                        "            \"type\": \"senderAddress\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"022-60121715\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2012,\n" +
                        "            \"type\": \"senderMobile\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"SALES\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2013,\n" +
                        "            \"type\": \"orderType\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"EMS标准快递\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2014,\n" +
                        "            \"type\": \"expressName\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"1171814891658\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2015,\n" +
                        "            \"type\": \"expressNo\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2016,\n" +
                        "            \"type\": \"sellerMemo\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"1000443641\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2017,\n" +
                        "            \"type\": \"vbelnVa\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"8000453530\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2018,\n" +
                        "            \"type\": \"vbelnVl\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"1018\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2019,\n" +
                        "            \"type\": \"lgort\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"data\": {\n" +
                        "                \"format\": \"string\",\n" +
                        "                \"value\": \"[{\\\"materialName\\\":\\\"6348整理箱(3180蓝+3050红+3300黄)套装\\\",\\\"number\\\":\\\"1\\\"}]\"\n" +
                        "            },\n" +
                        "            \"auth\": \"\",\n" +
                        "            \"index\": 2020,\n" +
                        "            \"type\": \"materials\"\n" +
                        "        }\n" +
                        "    ]",
                BarcodeRegisterValueVO.class);

        attrs.forEach(k -> System.out.println(k));

        BarcodeRegisterVO registerVO = new BarcodeRegisterVO();
        registerVO.setValue(attrs);

        System.out.println(1);

        BarcodeSNMSRegisterVO snmsRegisterVO = CopyUtil.objectCopy(registerVO, BarcodeSNMSRegisterVO.class);
        snmsRegisterVO.getValue().forEach(k -> {
            if (k.getData().getValue().equals(null)) {
                System.out.println(k.getType());
            }
        });
    }
}
