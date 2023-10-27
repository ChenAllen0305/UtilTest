package PatternAndMatcher;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

/**
 * @className: EmailPatternTest
 * @author: ChenLun
 * @date: 2022/12/7 17:15
 * @description:
 */
@Slf4j
public class EmailPatternTest {
    public static void main(String[] args) {
        String EMAIL_PATTERN = "^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$";

        String email = "1_@qq.com";

        boolean isEmail = Pattern.matches(EMAIL_PATTERN, email);
        log.info("result : " + isEmail);
    }
}
