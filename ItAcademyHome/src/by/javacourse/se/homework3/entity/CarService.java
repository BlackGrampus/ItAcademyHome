package by.javacourse.se.homework3.entity;

import by.javacourse.se.homework3.constants.Color;
import by.javacourse.se.homework3.constants.OptionPassengerCar;
import by.javacourse.se.homework3.constants.WheelR;

public class CarService {

    private final PassengerCar _clientCar;

    public CarService(PassengerCar clientCar) {
        this._clientCar = clientCar;
    }

    public void changeColorCar(PassengerCar _clientCar, Color color) {
        _clientCar.set_color(color);
    }

    public void changeWheelRCar(PassengerCar _clientCar, WheelR wheelR) {
        _clientCar.set_wheelR(wheelR);
    }

    public void addOptionCar(PassengerCar _clientCar, OptionPassengerCar option) {
        OptionPassengerCar[] tempOption = new OptionPassengerCar[_clientCar.get_option().length + 1];
        int counter = 0;

        for (OptionPassengerCar elementOpt : _clientCar.get_option()) {
            if (elementOpt.name().equals(option.name())) {
                counter++;
            }
        }

        if (counter == 0) {
            for (int i = 0; i < tempOption.length - 1; i++) {
                tempOption[i] = _clientCar.get_option()[i];
            }
            tempOption[tempOption.length - 1] = option;
            _clientCar.set_option(tempOption);
        }
    }

    public void difOptionCar(PassengerCar _clientCar, OptionPassengerCar option) {
        OptionPassengerCar[] tempLong = new OptionPassengerCar[_clientCar.get_option().length];
        int counter = 0;

        for (int i = 0; i < _clientCar.get_option().length; i++) {
            if (!(_clientCar.get_option()[i].name().equals(option.name()))) {
                tempLong[i - counter] = _clientCar.get_option()[i];
            } else {
                counter++;
            }

        }
        OptionPassengerCar[] tempNewOption = new OptionPassengerCar[(tempLong.length-counter)];

        for (int i = 0; i < tempNewOption.length; i++) {
                tempNewOption[i] = tempLong[i];
        }
        _clientCar.set_option(tempNewOption);
    }
}
