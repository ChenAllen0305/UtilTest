package TextOutput;

public class PointDataTypeOutput {
    public static void main(String[] args) {
        for (int i=1; i<=10; i++) {
            System.out.println("(p" + i + ":PointDataType{title:'告警值" + i + "'}),");
        }
    }
}
