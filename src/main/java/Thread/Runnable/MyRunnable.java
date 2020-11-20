package Thread.Runnable;

import java.util.Date;

public class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println(new Date());
    }
}
