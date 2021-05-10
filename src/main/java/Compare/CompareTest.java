package Compare;

import Compare.enrity.ThreadContextEntity;

/**
 * ClassName: CompareTest
 * Author: ChenLun
 * date: 2021/4/13
 * Description:
 */
public class CompareTest {
    public static void main(String[] args) {

        String result = ThreadContextEntity.get("tenantCode") == null ? "meta" : ThreadContextEntity.get("tenantCode").toString();
        System.out.println(result);
        if (ThreadContextEntity.get("tenantCode") == null) {
            System.out.println("meta");
        } else {
            System.out.println(ThreadContextEntity.get("tenantCode").toString());
        }
    }
}
