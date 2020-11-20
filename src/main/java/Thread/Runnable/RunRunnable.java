package Thread.Runnable;

public class RunRunnable {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Complete");
    }
}
