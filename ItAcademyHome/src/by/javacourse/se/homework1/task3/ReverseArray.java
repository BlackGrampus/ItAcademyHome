package by.javacourse.se.homework1.task3;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] inArray = {-1, 2, 0, 4, 5, 6, -7, 8};
        reverseArray(inArray);
    }

    public static void reverseArray(int[] array) {
        System.out.println("Исходный массив : " + Arrays.toString(array));

        if (array == null || array.length <= 1) {
            System.out.println("Массив пуст");
            return;
        }

        for (int i = 0; i < array.length / 2; i++) {
            int tempElement = array[i];
            array[i] = array[(array.length - 1) - i];
            array[(array.length - 1) - i] = tempElement;
        }
        System.out.println("Инвертированный массив: " + Arrays.toString(array));
    }
}
