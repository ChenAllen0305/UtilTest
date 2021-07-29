package ConfigurationTest;

import org.springframework.beans.factory.annotation.Value;

/**
 * ClassName: ValueTest
 * Author: ChenLun
 * date: 2021/7/19
 * Description:
 */
public class ValueTest {

    @Value("${test.array1}")
    private String[] testArray1;

    @Value("${test.array2}")
    private String[] testArray2;

    @Value("${test.array3}")
    private String[] testArray3;

    public void logOut() {
        System.out.println(testArray1);
        System.out.println(testArray2);
        System.out.println(testArray3);
    }
}
