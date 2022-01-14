package by.javacourse.se.homework1.task7;

public class MaxSumArray {
    public static void main(String[] args) {

        int[] inArray = {1, 0, 4, 8, 9, 1};
        sumMaxArray(inArray);
    }

    public static void sumMaxArray(int arr[]) {
        int[] maxSumArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                maxSumArray[i] = arr[i];
            }
            if (i == 1) {
                maxSumArray[i] = Math.max(maxSumArray[(i - 1)], arr[i]);
            }
            if (i >= 2) {
                maxSumArray[i] = Math.max(maxSumArray[i - 1], arr[i] + maxSumArray[i - 2]);
            }
        }
        System.out.println("Max сумма элементов массива: " + maxSumArray[arr.length - 1]);
    }
}
