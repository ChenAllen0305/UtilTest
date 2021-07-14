package SupplyChainFinance.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName: OrderTypeEnum
 * Author: ChenLun
 * date: 2021/6/28
 * Description:
 */
@AllArgsConstructor
@Getter
public enum OrderTypeEnum {
    UNKNOWN(-1, "未知"),
    SALES(0, "销售订单"),
    PURCHASE(1, "采购订单"),

    ;

    @JsonValue
    private int index;
    private String name;

    @JsonCreator
    public static OrderTypeEnum getEnum(int index) {
        for (OrderTypeEnum c : OrderTypeEnum.values()) {
            if (c.getIndex() == index) {
                return c;
            }
        }
        return OrderTypeEnum.UNKNOWN;
    }
}
