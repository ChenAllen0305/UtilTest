package StringTest;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @className: IdTest
 * @author: ChenLun
 * @date: 2023/4/13 10:36
 * @description:
 */
@Slf4j
public class IdTest {
    public static void main(String[] args) {
        List<String> userIds = new ArrayList<>();
        List<String> companyIds = new ArrayList<>();
        for (int i = 0; i < 93; i++) {
            String userId = UUID.randomUUID().toString();
            log.info("userId: " + userId);
            userIds.add(userId);
        }
        for (int i = 0; i < 93; i++) {
            String companyId = UUID.randomUUID().toString();
            log.info("companyId: " + companyId);
            companyIds.add(companyId);
        }
        for (int i = 0; i < 93; i++) {
            String userId = userIds.get(i);
            String companyId = companyIds.get(i);
            log.info("companyUser: ('" + companyId + "', '" + userId + "', '1', '1', '1', NULL, NULL)");
        }
    }
}
