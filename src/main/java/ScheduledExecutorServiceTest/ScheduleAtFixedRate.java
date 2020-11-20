package ScheduledExecutorServiceTest;

import Thread.Runnable.MyRunnable;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleAtFixedRate {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newSingleThreadScheduledExecutor();
        System.out.println(new Date());
        scheduledExecutorService.scheduleAtFixedRate(new MyRunnable(),
                3, 4, TimeUnit.SECONDS);
    }

    public void outDate() {
        System.out.println(new Date());
    }


}
