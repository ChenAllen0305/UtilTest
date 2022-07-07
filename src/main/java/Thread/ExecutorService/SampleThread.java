package Thread.ExecutorService;

import Util.DateTimeUtils;

import java.util.Date;

/**
 * ClassName: SampleThread
 * Author: ChenLun
 * date: 2021/5/19
 * Description:
 */
public class SampleThread implements Runnable {
    private int no;
    private int time;

    public SampleThread(int no, int time) {
        this.no = no;
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println("No." + no + " start ID:" + Thread.currentThread().getId() + " 生命周期:" + time + " 现在时间:" + DateTimeUtils.format(new Date()));
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("No." + no + " end ID:" + Thread.currentThread().getId() + " 生命周期:" + time + " 现在时间:" + DateTimeUtils.format(new Date()));
    }
}
