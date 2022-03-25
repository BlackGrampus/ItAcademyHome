package by.javacourse.se.project.main;

import by.javacourse.se.project.dealers.CarDealer;
import by.javacourse.se.project.entity.car.SedanCar;
import by.javacourse.se.project.entity.car.SportCar;
import by.javacourse.se.project.entity.car.SuvCar;
import by.javacourse.se.project.entity.order.OrderSedanCar;
import by.javacourse.se.project.entity.order.OrderSportCar;
import by.javacourse.se.project.entity.order.OrderSuvCar;
import by.javacourse.se.project.enums.*;
import by.javacourse.se.project.factories.CarFactories;
import by.javacourse.se.project.factories.SedanCarFactory;
import by.javacourse.se.project.services.AddOptionsCarService;
import by.javacourse.se.project.services.CarServices;
import by.javacourse.se.project.services.RemoveOptionsCarService;

public class Main {
    public static void main(String[] args) {
        try {
            CarServices carServices = new CarServices();
            CarFactories carFactories = new CarFactories(carServices);
            CarDealer carDealer = new CarDealer(carServices, carFactories);

            System.out.println(carFactories.getSedanCarFactory().getStorageCar());
            System.out.println(carFactories.getSportCarFactory().getStorageCar());
            System.out.println(carFactories.getSuvCarFactory().getStorageCar());

            try {
                SuvCar suvCar = carDealer.getCarByOrder(new OrderSuvCar(ColorEnum.YELLOW,
                        ModelEnum.C4,
                        2022,
                        WheelREnum.R22,
                        2200,
                        "Cat"));

                System.out.println(suvCar);
            } catch (NullPointerException e) {
                System.out.println("Параметр не может быть null");
            }


            try {
                SportCar sportCar = carDealer.getCarByOrder(new OrderSportCar(ColorEnum.YELLOW,
                        ModelEnum.C4,
                        2022,
                        WheelREnum.R18,
                        2000,
                        1850,
                        OptionCarEnum.ABS));

                System.out.println(sportCar);
                System.out.println(carFactories.getSportCarFactory().getStorageCar());
            } catch (NullPointerException e) {
                System.out.println("Параметр не может быть null");
            }

            try {
                SedanCar sedanCar = carDealer.getCarByOrder(new OrderSedanCar(ColorEnum.WHITE,
                        ModelEnum.C5,
                        2022,
                        WheelREnum.R16,
                        2200,
                        TrunkEnum.MEDIUM,
                        OptionCarEnum.ABS,
                        OptionCarEnum.VSM));

                System.out.println(sedanCar);
                System.out.println(carFactories.getSedanCarFactory().getStorageCar());

                carDealer.addOptionInCar(sedanCar, OptionCarEnum.ESP);
                System.out.println(sedanCar);

                carDealer.addOptionInCar(sedanCar, OptionCarEnum.ABS);
                carDealer.removeOptionInCar(sedanCar, OptionCarEnum.ABS);
                System.out.println(sedanCar);

            } catch (NullPointerException e) {
                System.out.println("Параметр не может быть null");
            }
        } catch (NullPointerException e) {
            System.out.println("Параметр не может быть null");
        }
    }
}
