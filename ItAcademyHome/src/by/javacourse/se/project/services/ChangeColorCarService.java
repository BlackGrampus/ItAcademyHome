package by.javacourse.se.project.services;

import by.javacourse.se.project.entity.car.Car;
import by.javacourse.se.project.enums.ColorEnum;
import by.javacourse.se.project.interfaces.CarChangeable;

public class ChangeColorCarService extends CarService implements CarChangeable<ColorEnum> {

    @Override
    public void changeCar(Car car, ColorEnum color) throws NullPointerException {
        if (car == null
                || color == null) {
            throw new NullPointerException();
        }
        synchronized (car) {
            try {
                if (car.get_color().equals(color)) {
                    System.out.println("Покраска не нужна.");
                    return;
                }

                car.set_color(color);
                System.out.println("Цвет изменён. Текущий цвет - " + car.get_color());

            } catch (ClassCastException e) {
                System.out.println("Вы не можете выбрать этот цвет.");
            }
        }
    }
}
