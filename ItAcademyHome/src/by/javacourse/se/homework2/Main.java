package by.javacourse.se.homework2;

import by.javacourse.se.homework2.task1.Month;
import by.javacourse.se.homework2.task2_10.Box;
import by.javacourse.se.homework2.task3.DataBufferFiveElements;
import by.javacourse.se.homework2.task4.Brand;
import by.javacourse.se.homework2.task4.Car;
import by.javacourse.se.homework2.task4.Color;

public class Main {
    public static void main(String[] args) {
//        double inValue = 10;

//        Task1
        System.out.println(Month.getNameByNumber(12));
        System.out.println(Month.getNumberByName("March"));

//        Task2
        Box box = new Box(10, 0, 10);
        System.out.println(box.getX() + " " + box.getY()+ " " + box.getZ());
        System.out.println(Box.getBoxType(box));
        Box box2 = new Box("Box[10,20,30]");
        System.out.println(box2.getX() + " " + box2.getY()+ " " + box2.getZ());
        System.out.println(Box.getBoxType(box));


//        Task3
        DataBufferFiveElements dataBuffer = new DataBufferFiveElements();
        dataBuffer.setValueOfDataBuffer(1);
        dataBuffer.setValueOfDataBuffer(2);
        dataBuffer.setValueOfDataBuffer(3);
        dataBuffer.setValueOfDataBuffer(4);
        dataBuffer.setValueOfDataBuffer(5);
        dataBuffer.setValueOfDataBuffer(7);
//        dataBuffer.setValueOfDataBuffer(8);
//        dataBuffer.setValueOfDataBuffer(9);

        System.out.println("Среднее значение:" + dataBuffer.getAverageValueOfDataBuffer());

//        Task4
        Car audi = new Car(Brand.AUDI, Color.RED);
        Car bmw = new Car(Brand.BMW, Color.BLACK);
        audi.changeColorCarByBrand(Color.BLUE);
        bmw.changeColorCarByBrand(Color.WHITE);
        System.out.println(audi.get_brand() + " " + audi.get_color());
        System.out.println(bmw.get_brand() + " " + bmw.get_color());
    }
}
