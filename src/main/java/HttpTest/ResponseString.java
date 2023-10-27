package HttpTest;

import lombok.Data;

/**
 * @className: ResponseCompanyClient
 * @author: ChenLun
 * @date: 2022/3/30 10:33
 * @description:
 */
@Data
public class ResponseString {

    private int code;

    private String data;

    private String message;
}
