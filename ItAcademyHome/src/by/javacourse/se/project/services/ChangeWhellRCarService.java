package by.javacourse.se.project.services;

import by.javacourse.se.project.entity.car.Car;
import by.javacourse.se.project.enums.WheelREnum;
import by.javacourse.se.project.interfaces.CarChangeable;

public class ChangeWhellRCarService extends CarService implements CarChangeable<WheelREnum> {

    @Override
    public void changeCar(Car car, WheelREnum wheelR) throws NullPointerException {
        if (car == null
                || wheelR == null) {
            throw new NullPointerException();
        }
        synchronized (car) {
            try {
                if (car.get_wheelR().equals(wheelR)) {
                    System.out.println("Смена колёс не нужна.");
                    return;
                }

                car.set_wheelR(wheelR);
                System.out.println("Колёса заменены. Текущий размер - " + car.get_wheelR());

            } catch (ClassCastException e) {
                System.out.println("Вы не можете выбрать этот размер колёс.");
            }
        }
    }
}
