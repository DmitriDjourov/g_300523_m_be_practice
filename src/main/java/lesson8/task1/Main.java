package lesson8.task1;

public class Main {
    public static void main(String[] args) {

        MyThread1 myThread1 = new MyThread1("Alfa", 300);
        MyThread1 myThread2 = new MyThread1("Betta", 500);

        myThread1.start();
        myThread2.start();

        DeamonThread deamonThread = new DeamonThread();

        deamonThread.start();

        Thread.currentThread().setName("Main");

        for (int i = 0; i < 10; i++) {
            System.out.printf("Поток %s выполнился %d раз.%n", Thread.currentThread().getName(), i + 1);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}