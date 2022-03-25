package by.javacourse.se.project.factories;

import by.javacourse.se.project.entity.StorageCar;
import by.javacourse.se.project.entity.car.SedanCar;
import by.javacourse.se.project.entity.order.OrderSedanCar;
import by.javacourse.se.project.enums.*;
import by.javacourse.se.project.services.CarServices;

import java.util.Arrays;

public class SedanCarFactory extends CarFactory {

    private StorageCar<SedanCar> storageCar = new StorageCar<>();

    public SedanCarFactory(
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

        storageCar.addToStorage(new SedanCar(ColorEnum.YELLOW,
                ModelEnum.C3,
                2022,
                WheelREnum.R20,
                1800,
                TrunkEnum.LARGE));
        storageCar.addToStorage(new SedanCar(ColorEnum.YELLOW,
                ModelEnum.C4,
                2022,
                WheelREnum.R18,
                2000,
                TrunkEnum.SMALL,
                OptionCarEnum.ABS));
        storageCar.addToStorage(new SedanCar(ColorEnum.YELLOW,
                ModelEnum.C5,
                2022,
                WheelREnum.R20,
                2200,
                TrunkEnum.MEDIUM,
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

    public SedanCar getCarByOrder(OrderSedanCar orderCar) {
        SedanCar newCar;
        for (SedanCar car : storageCar.getStorage()) {
            boolean noChange = car.get_model().equals(orderCar.get_model())
                    && car.getYearOfManufacture().equals(orderCar.getYearOfManufacture())
                    && car.getEngineCapacity().equals(orderCar.getEngineCapacity())
                    && car.get_trunk().equals(orderCar.get_trunk());

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

                SedanCar(
                orderCar.get_color(),
                orderCar.get_model(),
                orderCar.getYearOfManufacture(),
                orderCar.get_wheelR(),
                orderCar.getEngineCapacity(),
                orderCar.get_trunk(), orderCar.getOptions().

                toArray(new OptionCarEnum[]{
                }));
        System.out.println("Создана необходимая машина: ");
        return newCar;
    }

    public StorageCar<SedanCar> getStorageCar() {
        return storageCar;
    }
}
