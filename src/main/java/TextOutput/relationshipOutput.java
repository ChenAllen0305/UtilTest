package TextOutput;

public class relationshipOutput {
    public static void main(String[] args) {
//        int j=235;
        for (int i=235; i<=311; i++) {
//            String s = "(al" + i + ")-[:POINTDATATYPE_OF]->(pdt" + i + "),";
            String s = "(al" + i + ")-[:ALARM_LEVEL_OF]->(moderate),";
//            j++;
            System.out.println(s);
        }
    }
}
