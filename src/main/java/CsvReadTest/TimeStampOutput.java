package CsvReadTest;

public class TimeStampOutput {
    public static void main(String[] args) {
        Long end = 1604412000000L;
        Long start = 1604333700000L;
        while (start < end) {
            System.out.println(end);
            end -= 900000L;
        }
    }
}
