package by.javacourse.se.homework3.entity;

import by.javacourse.se.homework3.constants.Color;
import by.javacourse.se.homework3.constants.WheelR;

public class CarDealer {

    private final CarService dealerCarService;
    private final CarFactory dealerCarFactory;
    private final Storage<PassengerCar> storage = new Storage<>();

    public CarDealer(CarService dealerCarService, CarFactory dealerCarFactory) {
        this.dealerCarService = dealerCarService;
        this.dealerCarFactory = dealerCarFactory;
    }

    public Storage<PassengerCar> getStorage() {
        return storage;
    }

    public void getACar(PassengerCar carOrder) {
        PassengerCar newCarByOrder = dealerCarFactory.getACarByOrder(carOrder);
        if (newCarByOrder != null) {
            storage.addToStorage(newCarByOrder);
        }
    }

    public void changeACar(PassengerCar carChanges, Color color, WheelR wheelR) {
        if (storage.getStorage().removeFirstOccurrence(carChanges)) {
            if (color != null) {
                dealerCarService.changeColorCar(carChanges, color);
            }
            if (wheelR != null) {
                dealerCarService.changeWheelRCar(carChanges, wheelR);
            }
            storage.addToStorage(carChanges);
        } else {
            System.out.println("Not found car in dealer storage");
        }
    }
}