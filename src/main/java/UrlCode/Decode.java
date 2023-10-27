package UrlCode;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @className: Decode
 * @author: ChenLun
 * @date: 2023/6/26 19:33
 * @description:
 */
@Slf4j
public class Decode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "编译";

        String charset = StandardCharsets.UTF_8.name();

        String encode = URLEncoder.encode(str, charset);
        log.info("encode: " + encode);

        String decode = URLDecoder.decode(encode, charset);
        log.info("decode: " + decode);

        String decode2 = URLDecoder.decode(str, charset);
        log.info("decode2: " + decode2);

    }
}
