package lesson1.task1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayService service = new ArrayService();

        int[] array = service.getArrayBySize(7);

        System.out.println(Arrays.toString(array));
    }
}