package by.javacourse.se.homework1.task8;

import java.util.*;

public class PayStudents {

    public static void main(String[] args) {

        int[] inArray = {1, 2, 3, 4, 5, 3, 2, 1, 2, 6, 5, 4, 3, 3, 2, 1, 1, 3, 3, 3, 4, 2};
        int minPay = 1;
        sumMinPay(inArray, minPay);
    }

    public static void sumMinPay(int arr[], int minPay) {
        int[] payArray = new int[arr.length];
        int tempCounter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                payArray[i] = minPay;
            } else {
                if (arr[i] > arr[i - 1]) {
                    payArray[i] = payArray[i - 1] + 1;
                    tempCounter = 0;
                }
                if (arr[i] <= arr[i - 1]) {
                    payArray[i] = minPay;
                    if (arr[i] == arr[i - 1]) {
                        tempCounter = 0;
                    } else {
                        tempCounter++;
                    }
                }
                if ((tempCounter > 0) && (arr[i] < arr[i - 1])) {
                    for (int j = i; j > (i - tempCounter); j--) {
                        if (payArray[j - 1] <= payArray[j]) {
                            payArray[j - 1] = payArray[j - 1] + 1;
                        }
                    }
                }
            }
        }
        System.out.println("Рейтинг студентов:    " + Arrays.toString(arr));
        System.out.println("Min сумма в деканате: " + Arrays.toString(payArray));
        System.out.println("Min сумма в деканате: " + Arrays.stream(payArray).sum());
    }
}
