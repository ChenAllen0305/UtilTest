package Thread.MyThread;

public class MyThread extends Thread{
    public MyThread(){
        super();
        System.out.println("The name of the current thread: " + Thread.currentThread().getName());
    }

    @Override
    public void run(){
        System.out.println("The name of the current thread: " + Thread.currentThread().getName());
    }
}
