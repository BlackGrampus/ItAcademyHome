package by.javacourse.se.homework3.entity;

import by.javacourse.se.homework3.constants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CarFactory {
    private final Color[] _color;
    private final Model[] _model;
    private final WheelR[] _wheelR;
    private final Integer[] engineCapacity;
    private final Storage<PassengerCar> storage = new Storage<>();
    private final CarService service;

    public CarFactory(Color[] color, Model[] model, WheelR[] wheelR,
                      Integer[] engineCapacity, CarService service) {
        this._color = color;
        this._model = model;
        this._wheelR = wheelR;
        this.engineCapacity = engineCapacity;
        this.service = service;
    }

    @Override
    public String toString() {
        return "CarFactory{" +
                "colors=" + Arrays.toString(_color) +
                ", models=" + Arrays.toString(_model) +
                ", wheelR=" + Arrays.toString(_wheelR) +
                ", engineCapacity=" + Arrays.toString(engineCapacity) +
                '}';
    }

    public CarService getService(PassengerCar carInStorage) {
        return service;
    }

    public Storage<PassengerCar> getStorage() {
        return storage;
    }

    private boolean compareColorCar(PassengerCar newPassengerCar) {
        int counter = 0;

        for (Color col : _color) {
            if (col.name().equals(newPassengerCar.get_color().name())) {
                counter++;
                break;
            }
        }

        if (counter > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean compareModelCar(PassengerCar newPassengerCar) {
        int counter = 0;

        for (Model model : _model) {
            if (model.name().equals(newPassengerCar.get_model().name())) {
                counter++;
                break;
            }
        }

        if (counter > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean compareWheelRCar(PassengerCar newPassengerCar) {
        int counter = 0;

        for (WheelR wheelR : _wheelR) {
            if (wheelR.name().equals(newPassengerCar.get_wheelR().name())) {
                counter++;
                break;
            }
        }

        if (counter > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean compareEngineCapacityCar(PassengerCar newPassengerCar) {
        int counter = 0;

        for (Integer capacity : engineCapacity) {
            if (capacity.equals(newPassengerCar.getEngineCapacity())) {
                counter++;
                break;
            }
        }

        if (counter > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean compareParamCar(PassengerCar newPassengerCar) {
        if (compareEngineCapacityCar(newPassengerCar) && compareColorCar(newPassengerCar)
                && compareModelCar(newPassengerCar) && compareWheelRCar(newPassengerCar)) {
            return true;
        } else {
            return false;
        }
    }

    public void makeANewCar(PassengerCar newPassengerCar) {
        if (compareParamCar(newPassengerCar)) {
            storage.addToStorage(newPassengerCar);
        } else {
            System.out.println("Wrong parameter a newCar");
        }

    }

    public PassengerCar getACarByOrder(PassengerCar carOrder) {
        PassengerCar newCarByOrder;
        boolean compare;

        if (compareParamCar(carOrder)) {
            compare = true;
        } else {
            compare = false;
        }

        if (compare) {
            storage.getStorage().removeFirstOccurrence(carOrder);
            newCarByOrder = carOrder;
        } else {
            newCarByOrder = null;
        }
        return newCarByOrder;
    }

    public PassengerCar getACarToChangeByOrder(PassengerCar carToChangeByOrder) {
        PassengerCar carToChange;
        int counter = 0;
        List<PassengerCar> listPriority = new ArrayList<>();

        for (PassengerCar store : storage.getStorage()) {
            if ((store.get_model().equals(carToChangeByOrder.get_model())) &&
                    (store.getYearOfManufacture().equals(carToChangeByOrder.getYearOfManufacture())) &&
                    (store.getEngineCapacity().equals(carToChangeByOrder.getEngineCapacity()))) {
                counter++;
                listPriority.add(store);
            }
        }

        if (counter > 0) {
            Iterator<PassengerCar> iterator = listPriority.iterator();

            while (iterator.hasNext()) {
                PassengerCar tempCarIterator = iterator.next();
                if (tempCarIterator.get_option() == carToChangeByOrder.get_option())
                listPriority.add(0, tempCarIterator);
            }
            while (iterator.hasNext()) {
                PassengerCar tempCarIterator = iterator.next();
                if ((tempCarIterator.get_option() == carToChangeByOrder.get_option()) &&
                        (tempCarIterator.get_wheelR() == carToChangeByOrder.get_wheelR())) {
                    listPriority.add(0, tempCarIterator);
                }
            }
            while (iterator.hasNext()) {
                PassengerCar tempCarIterator = iterator.next();
                if ((tempCarIterator.get_option() == carToChangeByOrder.get_option()) &&
                        (tempCarIterator.get_color() == carToChangeByOrder.get_color())) {
                    listPriority.add(0, tempCarIterator);
                }
            }
            carToChange = listPriority.get(0);
        } else {
            carToChange = null;
        }
        return carToChange;
    }
}

