package Test;

public class booleanTest {
    public static void main(String[] args) {
        int i =1;
        int j=1;
        Boolean flag = i == 1;
//        System.out.println(flag);
        Boolean lastflat = j == 2;
        if(flag && lastflat){
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}
