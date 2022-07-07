package UUID;

import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            UUID uuid = UUID.randomUUID();
            String uuidStr = UUID.randomUUID().toString();
            System.out.println(uuid.toString());
        }
    }
}
