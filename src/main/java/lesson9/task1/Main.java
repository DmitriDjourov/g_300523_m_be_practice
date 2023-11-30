package lesson9.task1;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        new Car("BMW", semaphore);
        new Car("Mersedes", semaphore);
        new Car("Renault", semaphore);
        new Car("Москвич", semaphore);
    }
}
