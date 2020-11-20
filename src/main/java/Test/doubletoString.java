package Test;

public class doubletoString {
    public static void main(String[] args) {
        Double val = 123125.1233;
        String[] value = val.toString().split("");
        for(String v : value){
            System.out.print(v);
        }
    }
}
