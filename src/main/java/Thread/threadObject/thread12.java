package Thread.threadObject;

import Thread.method.NonSynchronizedMethod;
import Thread.method.SynchronizedMethod;

public class thread12 {
    public static class ThreadOne extends Thread {

    NonSynchronizedMethod nonSynchronizedMethod;
    SynchronizedMethod synchronizedMethod;

    public ThreadOne(NonSynchronizedMethod nonSynchronizedMethod) {
        this.nonSynchronizedMethod = nonSynchronizedMethod;
    }
    public ThreadOne(SynchronizedMethod synchronizedMethod){
        this.synchronizedMethod = synchronizedMethod;
    }

//    @Override
//    public void run() {
//        nonSynchronizedMethod.printNumbers();
//    }

    @Override
    public void run() {
        SynchronizedMethod.printNumbers();
    }
}

    public static class ThreadTwo extends Thread {

        NonSynchronizedMethod nonSynchronizedMethod;
        SynchronizedMethod synchronizedMethod;

        public ThreadTwo(NonSynchronizedMethod nonSynchronizedMethod) {
            this.nonSynchronizedMethod = nonSynchronizedMethod;
        }
        public ThreadTwo(SynchronizedMethod synchronizedMethod){
            this.synchronizedMethod = synchronizedMethod;
        }

//        @Override
//        public void run() {
//            nonSynchronizedMethod.printNumbers();
//        }

        @Override
        public void run() {
            SynchronizedMethod.printNumbers();
        }
    }
}
