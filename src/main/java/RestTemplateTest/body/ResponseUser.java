package RestTemplateTest.body;

import lombok.Data;

/**
 * @className: ResponseBody
 * @author: ChenLun
 * @date: 2022/3/29 15:26
 * @description:
 */
@Data
public class ResponseUser {

    private int code;

    private User data;

    private String message;
}
