package ListTest;

import java.util.Arrays;
import java.util.List;

/**
 * @className: ListTest.MatchUtil
 * @author: ChenLun
 * @date: 2022/3/10 17:04
 * @description:
 */
public class MatchUtil {
    public static void main(String[] args) {
        List<String> pathAuthIgnore = Arrays.asList("/api/usercenter/v1/company/query/condition", "/api/usercenter/v1/company/page");
        String requestUri = "/api/usercenter/v1/company";

        System.out.println(requestUri.contains("/api/usercenter/v1/company/page"));

        if (pathAuthIgnore.stream().noneMatch(requestUri::contains)) {
            System.out.println(1);
        }
        System.out.println(2);
    }
}
