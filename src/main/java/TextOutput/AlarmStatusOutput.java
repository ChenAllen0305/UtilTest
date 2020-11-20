package TextOutput;

public class AlarmStatusOutput {
    public static void main(String[] args) {
        for (int i=1; i<=10; i++) {
            System.out.println("(as" + i + ":AlarmStatus{title:'告警值" + i + "',name:'AlarmValue" + i + "'," +
                    "activity:true,sn:1595813216336,condition:'产生告警值" + i + "'}),");
//            System.out.println("(as" + i + ")-[:POINTDATATYPE_OF]->(p" + i + "),");
//            System.out.println("(as" + i + ")-[:ALARM_LEVEL_OF]->(moderate),");
//            System.out.println("(as" + i + ")<-[:ABNORMAL_TYPE_OF]-(alarm),");
        }
    }
}
