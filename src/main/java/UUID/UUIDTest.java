package UUID;

import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            UUID uuid = UUID.randomUUID();
            String uuidStr = UUID.randomUUID().toString();
            String[] arrayStr = uuidStr.split("-");
//            Arrays.asList(arrayStr).forEach(System.out::println);
            System.out.println(arrayStr[3] + arrayStr[4].substring(0, 4));
        }
    }
}
