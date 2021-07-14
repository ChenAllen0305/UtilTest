package SupplyChainFinance.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName: OrderStatusEnum
 * Author: ChenLun
 * date: 2021/6/28
 * Description: 订单状态枚举
 */
@AllArgsConstructor
@Getter
public enum OrderStatusEnum {
    UNKNOWN(-1, "未知"),
    BECONFIRMED(0, "待确认"),
    CONFIRMED(1, "已接单"),
    DELIVERY(2, "已发货"),
    RECEIVING(3, "已验收"),
    FINISHED(4, "已结束"),
    WITHDRAW(5, "已撤回"),

            ;

    @JsonValue
    private int index;
    private String name;

    @JsonCreator
    public static OrderStatusEnum getEnum(int index) {
        for (OrderStatusEnum c : OrderStatusEnum.values()) {
            if (c.getIndex() == index) {
                return c;
            }
        }
        return OrderStatusEnum.UNKNOWN;
    }
}
