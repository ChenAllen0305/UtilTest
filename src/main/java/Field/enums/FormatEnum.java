package Field.enums;

import Field.object.BaseEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FormatEnum implements BaseEnum {
    UNKNOWN(-1, "未知"),
    STRING(1, "string"),//字符串
    DECIMAL(2, "decimal"),//数字
    ENUM(3, "enum"),//枚举
    PICTURE(4, "picture"),//图片
    BOOLEAN(5, "boolean"),//布尔
    TIME(6, "time"),//时间
    RULE(7, "rule"),//规则
    CUSTOM(8, "自定义规则"),//自定义规则，由于枚举7已经上线，为了防止老数据冲突，特此分开
    ;

    @JsonValue
    private int index;
    private String name;

    @JsonCreator
    public static FormatEnum getEnum(int index) {
        for (FormatEnum c : FormatEnum.values()) {
            if (c.getIndex() == index) {
                return c;
            }
        }
        return FormatEnum.UNKNOWN;
    }

    public String getCNName() {
        switch (this.index) {
            case 1:
                return "字符串";
            case 2:
                return "数字";
            case 3:
                return "枚举";
            case 4:
                return "图片";
            case 5:
                return "布尔";
            case 6:
                return "时间";
            case 7:
                return "属性值规则";//已经不用
            case 8:
                return "自定义规则";
            default:
                return "未知";
        }
    }
}
