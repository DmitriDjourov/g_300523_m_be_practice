package lesson10.task1;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Truck extends Thread {

    private CyclicBarrier barrier;


    public Truck(String name, CyclicBarrier barrier) {
        setName(name);
        this.barrier = barrier;
        start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                Random random = new Random();

                int delay = random.nextInt(1000, 10000);
                sleep(delay);
                System.out.printf("Грузовик %s подъехал к переправе %n", getName());

                barrier.await();

                System.out.printf("Грузовик %s достиг другого берега %n", getName());

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}




