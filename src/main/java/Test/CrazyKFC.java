package Test;

import lombok.extern.slf4j.Slf4j;

/**
 * @className: Test.CrazyKFC
 * @author: ChenLun
 * @date: 2022/7/21 10:53
 * @description:
 */
@Slf4j
public class CrazyKFC {
    public static void main(String[] args) {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            log.error("KFC crazy Thursday, v me 50 RBM");
        }
    }
}
