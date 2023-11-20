package lesson6.task2;

public class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <1000000; i++) {
            Main.counter.incrementAndGet();
        }
    }
}
