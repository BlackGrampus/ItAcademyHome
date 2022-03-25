package by.javacourse.se.project.dealers;

import by.javacourse.se.project.entity.car.Car;
import by.javacourse.se.project.entity.car.SedanCar;
import by.javacourse.se.project.entity.car.SportCar;
import by.javacourse.se.project.entity.car.SuvCar;
import by.javacourse.se.project.entity.order.OrderSedanCar;
import by.javacourse.se.project.entity.order.OrderSportCar;
import by.javacourse.se.project.entity.order.OrderSuvCar;
import by.javacourse.se.project.enums.ColorEnum;
import by.javacourse.se.project.enums.OptionCarEnum;
import by.javacourse.se.project.enums.WheelREnum;
import by.javacourse.se.project.factories.CarFactories;
import by.javacourse.se.project.services.CarServices;

public class CarDealer {

    private final CarServices services;
    private final CarFactories factories;

    public CarDealer(CarServices services, CarFactories factories) {
        this.services = services;
        this.factories = factories;
    }

    public void changeCar(Car car, ColorEnum carColors)
            throws NullPointerException {

        if (car == null || carColors == null) {
            throw new NullPointerException();
        }
        services.getChangeColorCarService().changeCar(car, carColors);
    }

    public void changeCar(Car car, WheelREnum wheelR)
            throws NullPointerException {

        if (car == null || wheelR == null) {
            throw new NullPointerException();
        }
        services.getChangeWhellRCarService().changeCar(car, wheelR);
    }

    public void changeCar(Car car, ColorEnum carColors, WheelREnum wheelR)
            throws NullPointerException {

        if (car == null
                || wheelR == null
                || carColors == null) {
            throw new NullPointerException();
        }
        services.getChangeColorCarService().changeCar(car, carColors);
        services.getChangeWhellRCarService().changeCar(car, wheelR);
    }

    public void addOptionInCar(Car car, OptionCarEnum carOption)
            throws NullPointerException {

        if (car == null || carOption == null) {
            throw new NullPointerException();
        }
        services.getAddOptionsCarService().changeCar(car, carOption);
    }

    public void removeOptionInCar(Car car, OptionCarEnum carOption)
            throws NullPointerException {

        if (car == null || carOption == null) {
            throw new NullPointerException();
        }
        services.getRemoveOptionsCarService().changeCar(car, carOption);
    }


    public SedanCar getCarByOrder(OrderSedanCar order)
            throws NullPointerException {

        if (order == null) {
            throw new NullPointerException();
        }
        return factories.getSedanCarFactory().getCarByOrder(order);
    }

    public SportCar getCarByOrder(OrderSportCar order)
            throws NullPointerException {

        if (order == null) {
            throw new NullPointerException();
        }
        return factories.getSportCarFactory().getCarByOrder(order);
    }

    public SuvCar getCarByOrder(OrderSuvCar order)
            throws NullPointerException {

        if (order == null) {
            throw new NullPointerException();
        }
        return factories.getSuvCarFactory().getCarByOrder(order);
    }
}