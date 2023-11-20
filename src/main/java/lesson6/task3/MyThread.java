package lesson6.task3;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread{

    private static int idCount;

    private int id;

    public static AtomicInteger common = new AtomicInteger();

    public MyThread() {
        this.id = ++idCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            common.getAndAdd(id);
        }
    }
}

