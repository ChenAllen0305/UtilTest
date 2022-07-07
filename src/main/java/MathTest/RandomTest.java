package MathTest;

import java.util.Random;

/**
 * ClassName: RandomTest
 * Author: ChenLun
 * date: 2021/9/26
 * Description:
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 1; i <= 20; i++) {
            System.out.println(random.nextInt(10) + 20);
        }
    }
}
