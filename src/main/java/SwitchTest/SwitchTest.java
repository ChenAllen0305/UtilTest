package SwitchTest;

public class SwitchTest {

    public static void main(String[] args) {
        String timeType = "month";
        Double result = getValue(timeType);
        System.out.println(result);
    }


    private static Double getValue(String timeType) {
        Double result = 0D;
        switch (timeType) {
            case "day": {
                return 1D;
            }
            case "month": {
                return 2D;
            }
            case "year": {
                return 3D;
            }
            case "amount": {
                return 4D;
            }
        }
        return result;
    }

}

