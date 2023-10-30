package lesson1.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayServiceTest {

    /*
    Задание:
    Придумать несколько тест-кейсов (минимум 3).
    На каждый тест-кейс написать отдельный тестовый метод в данном классе.
    Тестовые методы должны тестировать функционал ArrayService.
     */

    private ArrayService service;

    @BeforeEach
    public void init() {
        service = new ArrayService();
    }

    @Test
    void getArrayOfIndexChosenSubArrayProof() {
        int a = 9;
        int first = 1;
        int third = 3;
        int fifth = 5;
        int[] ints = service.getArrayBySize(a);
        Assertions.assertEquals(first, ints[0]);
        Assertions.assertEquals(third, ints[2]);
        Assertions.assertEquals(fifth, ints[4]);
    }

    @Test
    void checkArrayLength() {
        int size = 5;
        Assertions.assertEquals(size, service.getArrayBySize(size).length);
    }

    @Test
    void getArrayBySizeExceptionsTest() {
        int size = -2;
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getArrayBySize(size));
    }

    @Test
    void getArrayBySizePositiadveTest() {
        int size = 5;
        Assertions.assertNotNull(service.getArrayBySize(size));
    }
}