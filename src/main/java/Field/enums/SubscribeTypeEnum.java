package Field.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @className: SubscribeEnum
 * @author: ChenLun
 * @date: 2022/4/25 16:39
 * @description:
 */
@AllArgsConstructor
@Getter
public enum SubscribeTypeEnum {
    UNKNOWN(-1, "未知"),
    HANDLE(1, "HANDLE"),
    META(2, "META");;

    @JsonValue
    private int index;
    private String name;

    @JsonCreator
    public static SubscribeTypeEnum getEnum(int index) {
        for (SubscribeTypeEnum c : SubscribeTypeEnum.values()) {
            if (c.getIndex() == index) {
                return c;
            }
        }
        return SubscribeTypeEnum.UNKNOWN;
    }
}
