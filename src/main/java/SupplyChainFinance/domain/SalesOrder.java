package SupplyChainFinance.domain;

import lombok.Data;
import SupplyChainFinance.enums.OrderStatusEnum;

import java.util.Date;
import java.util.List;

/**
 * ClassName: SalesOrder
 * Author: ChenLun
 * date: 2021/6/28
 * Description: 销售订单
 */
@Data
public class SalesOrder {
    private String id;
    //订单标识
    private String orderNumber;
    //销售公司
    private String salesCompany;
    //销售金额
    private double orderAmount;
    //销售日期
    private Date orderDate;
    //订单状态
    private OrderStatusEnum orderStatusEnum;
    //销售产品列表
    private List<Product> products;
}
