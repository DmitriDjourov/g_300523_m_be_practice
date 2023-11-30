package lesson8.task3;

public class Test {

    public static int value;
    public int value1;

    public static void setValue(int value1) {
        value = value1;
    }

    public void setValue1(int value2) {
        value1 = value2;
    }

    public void test() {
        setValue(1);
        setValue1(3);
    }
}