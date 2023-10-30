package lesson1.task1;

public class ArrayService {

    // 5 -> [1, 2, 3, 4, 5]
    // 3 -> [1, 2, 3]
    public int[] getArrayBySize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Размер массива не может быть отрицательным.");
        }
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}