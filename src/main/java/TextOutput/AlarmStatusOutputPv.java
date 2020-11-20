package TextOutput;

public class AlarmStatusOutputPv {
    public static void main(String[] args) {
        int j=1;
        for (int i=1; i<71; i++) {
//            if (i % 5 == 1) {
//                System.out.println("(pdt" + i + ":PointDataType{name:'S" + j + "CUnchange'}),");
//            }
//            if (i % 5 == 2) {
//                System.out.println("(pdt" + i + ":PointDataType{name:'S" + j + "CBig'}),");
//            }
//            if (i % 5 == 3) {
//                System.out.println("(pdt" + i + ":PointDataType{name:'S" + j + "CSmall'}),");
//            }
//            if (i % 5 == 4) {
//                System.out.println("(pdt" + i + ":PointDataType{name:'S" + j + "CLarge'}),");
//            }
//            if (i % 5 == 0) {
//                System.out.println("(pdt" + i + ":PointDataType{name:'S" + j + "CLow'}),");
//                j++;
//            }

            if (i % 5 == 1) {
                System.out.println("(als" + i + ":AlarmStatus{alarm:true, activity:true, name:'S" + j + "CUnchange'," +
                        "title:'S" + j + "CUnchange',stationId:344503}),");
            }
            if (i % 5 == 2) {
                System.out.println("(als" + i + ":AlarmStatus{alarm:true, activity:true, name:'S" + j + "CBig'," +
                        "title:'S" + j + "CBig',stationId:344503}),");
            }
            if (i % 5 == 3) {
                System.out.println("(als" + i + ":AlarmStatus{alarm:true, activity:true, name:'S" + j + "CSmall'," +
                        "title:'S" + j + "CSmall',stationId:344503}),");
            }
            if (i % 5 == 4) {
                System.out.println("(als" + i + ":AlarmStatus{alarm:true, activity:true, name:'S" + j + "CLarge'," +
                        "title:'S" + j + "CLarge',stationId:344503}),");
            }
            if (i % 5 == 0) {
                System.out.println("(als" + i + ":AlarmStatus{alarm:true, activity:true, name:'S" + j + "CLow'," +
                        "title:'S" + j + "CLow',stationId:344503}),");
                j++;
            }


//            System.out.println("(als" + i + ")-[:POINTDATATYPE_OF]->(pdt" + i + "),");
//            System.out.println("(als" + i + ")-[:ALARM_LEVEL_OF]->(moderate),");
//            System.out.println("(als" + i + ")-[:ABNORMAL_TYPE_OF]->(warn),");

//            if (i % 5 == 1) {
//                System.out.println("(als" + i + ")-[:ALARM_LEVEL_OF]->(slight),");
//            }
//            if (i % 5 == 2) {
//                System.out.println("(als" + i + ")-[:ALARM_LEVEL_OF]->(moderate),");
//            }
//            if (i % 5 == 3) {
//                System.out.println("(als" + i + ")-[:ALARM_LEVEL_OF]->(moderate),");
//            }
//            if (i % 5 == 4) {
//                System.out.println("(als" + i + ")-[:ALARM_LEVEL_OF]->(serious),");
//            }
//            if (i % 5 == 0) {
//                System.out.println("(als" + i + ")-[:ALARM_LEVEL_OF]->(serious),");
//                j++;
//            }
        }
    }
}
