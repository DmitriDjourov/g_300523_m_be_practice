package lesson10.task1;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(2, new FerryBoat());

        new Truck("MAN", barrier);
        new Truck("Volvo", barrier);
        new Truck("Mercedes", barrier);
        new Truck("Kamaz", barrier);
        new Truck("MAZ", barrier);
        new Truck("Iveco", barrier);
        new Truck("ISUZU", barrier);
        new Truck("Scania", barrier);

    }
}