package SupplyChainFinance.domain;

import SupplyChainFinance.enums.OrderStatusEnum;
import SupplyChainFinance.enums.OrderTypeEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * ClassName: Order
 * Author: ChenLun
 * date: 2021/6/28
 * Description:
 */
@Data
public class Order {
    private String id;
    //订单标识
    private String orderNumber;
    //订单交易公司
    private String orderCompany;
    //销售金额
    private double orderAmount;
    //销售日期
    private Date orderDate;
    //订单类型
    private OrderTypeEnum orderTypeEnum;
    //订单状态
    private OrderStatusEnum orderStatusEnum;
    //销售产品列表
    private List<Product> products;
}
