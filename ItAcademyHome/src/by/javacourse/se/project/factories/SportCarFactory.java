package by.javacourse.se.project.factories;

import by.javacourse.se.project.entity.StorageCar;
import by.javacourse.se.project.entity.car.SportCar;
import by.javacourse.se.project.entity.order.OrderSportCar;
import by.javacourse.se.project.enums.*;
import by.javacourse.se.project.services.CarServices;

import java.util.Arrays;

public class SportCarFactory extends CarFactory {

    private StorageCar<SportCar> storageCar = new StorageCar<>();

    public SportCarFactory(
            ColorEnum[] _color,
            ModelEnum[] _model,
            WheelREnum[] _wheelR,
            Integer[] engineCapacity,
            CarServices services
    ) {
        super(
                _color,
                _model,
                _wheelR,
                engineCapacity,
                services
        );

        storageCar.addToStorage(new SportCar(ColorEnum.YELLOW,
                ModelEnum.C3,
                2022,
                WheelREnum.R20,
                1800,
                1800));
        storageCar.addToStorage(new SportCar(ColorEnum.YELLOW,
                ModelEnum.C4,
                2022,
                WheelREnum.R18,
                2000,
                1850,
                OptionCarEnum.ABS));
        storageCar.addToStorage(new SportCar(ColorEnum.YELLOW,
                ModelEnum.C5,
                2022,
                WheelREnum.R20,
                2200,
                1900,
                OptionCarEnum.ABS,
                OptionCarEnum.VSM));
    }

    @Override
    public void printEngineCapacities() {
        System.out.println(Arrays.toString(super.getEngineCapacity()));
    }

    @Override
    public void printModels() {
        System.out.println(Arrays.toString(super.get_model()));
    }

    @Override
    public void printColors() {
        System.out.println(Arrays.toString(super.get_model()));
    }

    @Override
    public void printWheelR() {
        System.out.println(Arrays.toString(super.get_wheelR()));
    }

    public SportCar getCarByOrder(OrderSportCar orderCar) {
        SportCar newCar;
        for (SportCar car : storageCar.getStorage()) {
            boolean noChange = car.get_model().equals(orderCar.get_model())
                    && car.getYearOfManufacture().equals(orderCar.getYearOfManufacture())
                    && car.getEngineCapacity().equals(orderCar.getEngineCapacity())
                    && car.getSpoilerSize().equals(orderCar.getSpoilerSize());

            if (noChange
                    && car.get_color().equals(orderCar.get_color())
                    && car.get_wheelR().equals(orderCar.get_wheelR())
                    && car.getOptions().equals(orderCar.getOptions())) {

                newCar = car;
                storageCar.diffToStorage(car);
                System.out.println("На складе фабрики найдена необходимая машина: ");
                return newCar;

            } else if (noChange
                    && car.get_color().equals(orderCar.get_color())
                    && car.getOptions().equals(orderCar.getOptions())) {
                newCar = car;
                storageCar.diffToStorage(car);
                System.out.println("На складе фабрики найдена необходимая машина: ");

                getServices().getChangeWhellRCarService().changeCar(newCar, orderCar.get_wheelR());
                return newCar;
            } else if (noChange
                    && car.get_wheelR().equals(orderCar.get_wheelR())
                    && car.getOptions().equals(orderCar.getOptions())) {
                newCar = car;
                storageCar.diffToStorage(car);
                System.out.println("На складе фабрики найдена необходимая машина: ");

                getServices().getChangeColorCarService().changeCar(newCar, orderCar.get_color());
                return newCar;
            } else if (noChange
                    && car.getOptions().equals(orderCar.getOptions())) {
                newCar = car;
                storageCar.diffToStorage(car);
                System.out.println("На складе фабрики найдена необходимая машина: ");

                getServices().getChangeWhellRCarService().changeCar(newCar, orderCar.get_wheelR());
                getServices().getChangeColorCarService().changeCar(newCar, orderCar.get_color());
                return newCar;
            }
        }

        newCar = new

                SportCar(
                orderCar.get_color(),
                orderCar.get_model(),
                orderCar.getYearOfManufacture(),
                orderCar.get_wheelR(),
                orderCar.getEngineCapacity(),
                orderCar.getSpoilerSize(), orderCar.getOptions().

                toArray(new OptionCarEnum[]{
                }));
        System.out.println("Создана необходимая машина: ");
        return newCar;
    }

    public StorageCar<SportCar> getStorageCar() {
        return storageCar;
    }
}
