package SupplyChainFinance.domain;

import lombok.Data;
import SupplyChainFinance.enums.OrderStatusEnum;

import java.util.Date;
import java.util.List;

/**
 * ClassName: PurchaseOrder
 * Author: ChenLun
 * date: 2021/6/28
 * Description: 采购订单
 */
@Data
public class PurchaseOrder {
    private String id;
    //订单标识
    private String orderNumber;
    //采购企业
    private String purchaseCompany;
    //采购金额
    private double orderAmount;
    //采购日期
    private Date orderDate;
    //订单状态
    private OrderStatusEnum orderStatusEnum;
    //采购产品列表
    private List<Product> products;
}
