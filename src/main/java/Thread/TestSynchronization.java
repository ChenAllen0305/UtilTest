package Thread;

import Thread.method.NonSynchronizedMethod;
import Thread.method.SynchronizedMethod;
import Thread.threadObject.thread12;

public class TestSynchronization {
    public static void main(String[] args) {
        NonSynchronizedMethod nonSynchronizedMethod = new NonSynchronizedMethod();
        SynchronizedMethod synchronizedMethod = new SynchronizedMethod();

//        thread12.ThreadOne threadOne = new thread12.ThreadOne(nonSynchronizedMethod);
        thread12.ThreadOne threadOne = new thread12.ThreadOne(synchronizedMethod);
        threadOne.setName("ThreadOne");

//        thread12.ThreadTwo threadTwo = new thread12.ThreadTwo(nonSynchronizedMethod);
        thread12.ThreadTwo threadTwo = new thread12.ThreadTwo(synchronizedMethod);
        threadTwo.setName("ThreadTwo");

        threadOne.start();
        threadTwo.start();
    }
}
