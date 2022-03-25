package by.javacourse.se.project.interfaces;

import by.javacourse.se.project.entity.car.Car;

public interface CarChangeable<T extends Enum> {

     void changeCar(Car car, T o);
}
