package lesson8.task3;

public class Main {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        myThread1.setName("Alfa");
        myThread2.setName("Betta");
        myThread3.setName("Gamma");
        myThread1.start();
        try {
            myThread1.join(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        myThread2.start();
        try {
            myThread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        myThread3.start();
        try {
            myThread2.join();
            myThread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Все потоки отработали!");
    }
}
