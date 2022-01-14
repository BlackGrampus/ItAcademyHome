package by.javacourse.se.homework1.task2;

public class FibonacciNumSum {
    public static void main(String[] args) {
        int inNumElement = 11;

        int valueFn = 0;
        int valueFn1 = 1;
        int valueFn2;
        int valueResaultSum = 0;

        System.out.print(valueFn + " " + valueFn1 + " ");
        for (int i = 3; i <= inNumElement; i++) {
            valueFn2 = valueFn1 + valueFn;

            System.out.print(valueFn2 + " ");
            if (valueFn2 % 2 == 0) {
                valueResaultSum += valueFn2;
            }
            valueFn = valueFn1;
            valueFn1 = valueFn2;
        }
        System.out.println();
        System.out.println("Сумма четных чисел Фибоначи : " + valueResaultSum);
    }
}