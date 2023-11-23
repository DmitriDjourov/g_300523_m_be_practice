package lesson7.task1;

public class Main {
    public static void main(String[] args) {
        ClassA classA = new ClassA();
        ClassB classB = new ClassB();
        classA.setClassB(classB);
        classB.setClassA(classA);

        MyThread1 myThread1 = new MyThread1(classA, "Alpha");
        MyThread2 myThread2 = new MyThread2(classB, "Beta");

//        myThread1.run();
//        myThread2.run();

        myThread1.start();
        myThread2.start();

        // Есть три потока
        // Первый поток выводит в консоль пять раз букву А (без переноса строки) -> AAAAA
        // Второй поток выводит в консоль пять раз букву Б (без переноса строки) -> БББББ
        // Третий поток выводит в консоль пять раз букву В (без переноса строки) -> ВВВВВ
        // Запустить все три потока одновременно, но добиться такого поведения,
        // чтобы результат в консоли был - АБВАБВАБВАБВАБВ
        // АБВААБВАБВ -> Х
        // Программа должна выполняться мгновенно, то есть всякие sleep и тому подобное
        // использовать нельзя.
    }
}