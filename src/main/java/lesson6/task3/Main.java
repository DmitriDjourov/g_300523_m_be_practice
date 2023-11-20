package lesson6.task3;

public class Main {

    // Есть класс, унаследованный от Thread.
    // На базе этого класса нужно создать пять объектов (пять потоков).
    // У каждого потока должен быть целочисленный идентификатор.
    // При создании объектов им автоматически должны назначаться идентификаторы
    // в порядке возрастания. То есть у первого объекта id - 1, у второго id - 2 и т.д.
    // Задача каждого потока - увеличить пять раз значение общей переменной на
    // значение своего идентификатора.
    // То есть первый поток должен увеличить значение переменной пять раз на 1,
    // второй - пять раз на 2 и т.д.
    // Вывести в консоль переменную. Ожидаемое значение - 75.

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();
        Thread thread3 = new MyThread();
        Thread thread4 = new MyThread();
        Thread thread5 = new MyThread();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();


        System.out.println(MyThread.common);
    }

}