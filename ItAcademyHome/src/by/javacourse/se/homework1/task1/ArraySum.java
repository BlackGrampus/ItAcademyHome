package by.javacourse.se.homework1.task1;

import java.lang.System;
import java.util.Arrays;

public class ArraySum {
    public static void main(String[] args) {
        int inSizeArray = 10;
        int[] array = new int[inSizeArray];
        makeARendomArray(array);
        sumArrayToStream(array);
        sumArrayFor(array);
    }

    public static void makeARendomArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20 - 5);
        }
        System.out.println("Исходный массив : " + Arrays.toString(arr));
    }

    public static void sumArrayToStream(int arr[]) {
        int sumResault = Arrays.stream(arr).filter(value -> (value > arr.length) || (value < arr.length)).sum();
        System.out.println("Сумма элементов массива ArraytoStream : " + sumResault);
    }

    public static void sumArrayFor(int arr[]) {
        int sumResault = 0;
        for (int element : arr) {
            if (element == arr.length) {
                continue;
            }
            sumResault += element;
        }
        System.out.println("Сумма элементов массива ArrayFor : " + sumResault);
    }
}
