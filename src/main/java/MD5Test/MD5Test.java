package MD5Test;

public class MD5Test {
    public static void main(String[] args) {
        String s = new String("wanke2020");
        String pass = MD5Util.encode(s, "@wanke");
        System.out.println(pass);
    }
}
