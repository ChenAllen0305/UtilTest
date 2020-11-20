package TextOutput;

public class sjidOutPut {
    public static void main(String[] args) {
//        Long i = 19147000000001L;
        String is = "1110999950101";
        for (int i = 41 ; i<=170 ; i ++) {
            String pn = is + i;
            System.out.println("insert into meas_sjzb values((select sjid from (select max(sjid)+1 as sjid from meas_sjzb) t1)," + pn +
                    ",1,1);");
        }
    }
}
