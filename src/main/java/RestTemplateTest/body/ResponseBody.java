package RestTemplateTest.body;

import lombok.Data;

/**
 * @className: ResponseBody
 * @author: ChenLun
 * @date: 2022/3/29 15:26
 * @description:
 */
@Data
public class ResponseBody<T> {

    private int code;

    private T data;

    private String message;
}
