package Thread.MyThread;

public class RunThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("Complete");
    }
}
