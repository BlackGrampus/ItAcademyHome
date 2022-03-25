package by.javacourse.se.project.services;

import by.javacourse.se.project.entity.car.Car;
import by.javacourse.se.project.enums.OptionCarEnum;
import by.javacourse.se.project.interfaces.CarChangeable;

public class RemoveOptionsCarService extends CarService implements CarChangeable<OptionCarEnum> {

    @Override
    public void changeCar(Car car, OptionCarEnum option) throws NullPointerException {
        if (car == null
                || option == null) {
            throw new NullPointerException();
        }
        synchronized (car) {
            car.removeOption(option);
        }
    }
}
