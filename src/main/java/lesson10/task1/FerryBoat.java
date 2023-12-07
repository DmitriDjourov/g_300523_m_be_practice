package lesson10.task1;

public class FerryBoat implements Runnable {

    private long start = System.currentTimeMillis();

    @Override
    public void run() {
        try {

            System.out.println("Паром отошел от берега");
            Thread.sleep(3000);

            System.out.printf("Паром выгрузил автомобили на противоположном берегу. Прошло: %d секунд. %n",
                    (System.currentTimeMillis() - start) / 1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
