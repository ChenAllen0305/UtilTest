package TextOutput;

public class MaxSjidOutput {
    public static void main(String[] args) {
        String start = "1110999950301";
        for (int i=1 ;i <=59 ; i++) {
            String number = start + i;
            System.out.println("insert into meas_sjzb values((select sjid from (select max(sjid)+1 as sjid from meas_sjzb) t1)," + number + ",1,1);");
        }
    }
}
