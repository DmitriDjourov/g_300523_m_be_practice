package lesson9.task1;

import java.util.concurrent.Semaphore;

public class Car extends Thread{
private Semaphore semaphore;
    public Car(String name,Semaphore semaphore) {
        setName(name);
        this.semaphore = semaphore;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(3000);
            System.out.printf("Автомобиль %s на старте %n",getName());
            sleep(3000);
            long start = System.currentTimeMillis();
            System.out.printf("Автомобиль %s начал движение %n",getName());
            sleep(3000);
            System.out.printf("Автомобиль %s подьехал к тоннелю %n",getName());
            sleep(3000);
            semaphore.acquire();
            System.out.printf("Автомобиль %s вьехал в тоннель %n",getName());
            sleep(3000);
            System.out.printf("Автомобиль %s выехал из тоннеля %n",getName());
            semaphore.release();
            sleep(3000);
            System.out.printf("Автомобиль %s финишировал за %d секунд %n",getName(),(System.currentTimeMillis() - start)/ 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
