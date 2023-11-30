package lesson9.task2;

import java.util.concurrent.CountDownLatch;

public class Main {
    private static final CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) {
        Passenger passenger1 = new Passenger("1", countDownLatch);
        Passenger passenger2 = new Passenger("2", countDownLatch);
        Passenger passenger3 = new Passenger("3", countDownLatch);
        Passenger passenger4 = new Passenger("4", countDownLatch);
        Passenger passenger5 = new Passenger("5", countDownLatch);
        Thread thread1 = new Thread(passenger1);
        Thread thread2 = new Thread(passenger2);
        Thread thread3 = new Thread(passenger3);
        Thread thread4 = new Thread(passenger4);
        Thread thread5 = new Thread(passenger5);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
