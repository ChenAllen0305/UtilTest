package DataGeneration;

public class VirtualAnalogPnGeneration {
    public static void main(String[] args) {
        Long pn = 100090000096L;
        String sql = "match (a:Analog)--(p:PointDataType) where a.pointNumber in [";
        do {
            sql += pn +",";
            pn++;
        } while (pn <= 100090000167L);
        sql += "] return *";
        System.out.println(sql);
    }
}
