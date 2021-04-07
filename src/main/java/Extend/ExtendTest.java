package Extend;

/**
 * @title: ExtendTest
 * @Author Chen Lun
 * @Date: 2021/3/14
 */
public class ExtendTest {
    public static void main(String[] args) {
        NextPlayer nextPlayer = new NextPlayer();
        nextPlayer.run();

        People one = new Player();
        one.run();
        Player two = (Player) one;
        two.run();
    }
}
