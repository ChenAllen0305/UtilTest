package SupplyChainFinance.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName: FinancingStatusEnum
 * Author: ChenLun
 * date: 2021/6/28
 * Description: 审核状态枚举
 */
@AllArgsConstructor
@Getter
public enum FinancingStatusEnum {
    UNKNOWN(-1, "未知"),
    BEAUDIT(0, "待审核"),
    PENDINGAPPROVAL(1, "待审批"),
    FINISHED(2, "已完成"),

    ;

    @JsonValue
    private int index;
    private String name;

    @JsonCreator
    public static FinancingStatusEnum getEnum(int index) {
        for (FinancingStatusEnum c : FinancingStatusEnum.values()) {
            if (c.getIndex() == index) {
                return c;
            }
        }
        return FinancingStatusEnum.UNKNOWN;
    }
}
