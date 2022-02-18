package by.javacourse.se.homework3.main;

import by.javacourse.se.homework3.constants.Color;
import by.javacourse.se.homework3.constants.Model;
import by.javacourse.se.homework3.constants.OptionPassengerCar;
import by.javacourse.se.homework3.constants.WheelR;
import by.javacourse.se.homework3.entity.*;

public class Main {
    public static void main(String[] args) {
        PassengerCar passenger = new PassengerCar(Color.BLACK, Model.C1, 2020,
                WheelR.R18, 2000, new OptionPassengerCar[]{OptionPassengerCar.ESP,
                OptionPassengerCar.ESP, OptionPassengerCar.HAC});
        System.out.println(passenger);

        CarService carService = new CarService(passenger);
        carService.changeColorCar(passenger, Color.RED);
        carService.addOptionCar(passenger, OptionPassengerCar.HAC);
        System.out.println(passenger);
        carService.difOptionCar(passenger, OptionPassengerCar.ESP);
        System.out.println(passenger);

        CarFactory carFactory = new CarFactory( Color.values(), Model.values(), WheelR.values(),
                new Integer[]{1600, 1800, 2000}, carService);

        System.out.println(carFactory);

        carFactory.makeANewCar(new PassengerCar(Color.WHITE, Model.C1, 2022,
                WheelR.R16, 2000, new OptionPassengerCar[]{OptionPassengerCar.ESP,
                OptionPassengerCar.ESP, OptionPassengerCar.HAC}));

        carFactory.makeANewCar(new PassengerCar(Color.BLUE, Model.C1, 2022,
                WheelR.R20, 2000, new OptionPassengerCar[]{OptionPassengerCar.ESP,
                OptionPassengerCar.ESP, OptionPassengerCar.HAC}));

        carFactory.makeANewCar(new PassengerCar(Color.YELLOW, Model.C1, 2022,
                WheelR.R18, 2000, new OptionPassengerCar[]{OptionPassengerCar.ESP,
                OptionPassengerCar.ESP, OptionPassengerCar.HAC}));

        System.out.println(carFactory.getStorage());
        System.out.println(carFactory.getACarToChangeByOrder(new PassengerCar(Color.YELLOW, Model.C1, 2022,
                WheelR.R24, 2000, new OptionPassengerCar[]{OptionPassengerCar.ESP,
                OptionPassengerCar.ESP, OptionPassengerCar.HAC})));


        carFactory.getACarToChangeByOrder(new PassengerCar(Color.YELLOW, Model.C1, 2022,
                WheelR.R20, 2000, new OptionPassengerCar[]{OptionPassengerCar.ESP,
                OptionPassengerCar.ESP, OptionPassengerCar.HAC}));
        System.out.println(carFactory.getStorage());



        CarDealer carDealer = new CarDealer(carService, carFactory);
        carDealer.getACar(new PassengerCar(Color.BLUE, Model.C4, 2022,
                WheelR.R20, 2000, new OptionPassengerCar[]{OptionPassengerCar.ESP,
                OptionPassengerCar.HAC}));
        System.out.println(carDealer.getStorage());

        carDealer.changeACar(new PassengerCar(Color.BLUE, Model.C4, 2022,
                WheelR.R20, 2000, new OptionPassengerCar[]{OptionPassengerCar.ESP,
                OptionPassengerCar.HAC}),Color.YELLOW,WheelR.R22);
        System.out.println(carDealer.getStorage());

        carDealer.getACar(new PassengerCar(Color.BLUE, Model.C1, 2020,
                WheelR.R18, 1800, new OptionPassengerCar[]{OptionPassengerCar.ESP,
                OptionPassengerCar.ESP, OptionPassengerCar.HAC}));

        System.out.println(carDealer.getStorage());
        System.out.println(carFactory.getStorage());
    }
}
