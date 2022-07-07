package TimeUnitTest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

/**
 * ClassName: DayTimeEnum
 * Author: ChenLun
 * date: 2021/5/24
 * Description:
 */
@AllArgsConstructor
public enum DayTimeEnum {
    INTRADAY("0", "日内"),
    DAY("1", "日"),
    MONTH("2", "月");

    private String index;
    private String name;

    @JsonValue
    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    @JsonCreator
    public static DayTimeEnum getEnum(String index) {
        for (DayTimeEnum c : DayTimeEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c;
            }
        }
        return DayTimeEnum.INTRADAY;
    }
}
