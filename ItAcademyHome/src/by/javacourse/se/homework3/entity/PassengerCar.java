package by.javacourse.se.homework3.entity;

import by.javacourse.se.homework3.constants.*;

import java.util.Arrays;

public class PassengerCar extends Car {

    private  OptionPassengerCar[] _option;

    public PassengerCar(Color color, Model model, Integer yearOfManufacture,
                        WheelR wheelR, Integer engineCapacity, OptionPassengerCar[] option) {
        super(color, model, yearOfManufacture, wheelR, engineCapacity);
        this._option = option;
    }

    public OptionPassengerCar[] get_option() {
        return _option;
    }

    public void set_option(OptionPassengerCar[] _option) {
        this._option = _option;
    }

    @Override
    public String toString() {
        return "PassengerCar{" +
                "_color=" + get_color() +
                ", _model=" + get_model() +
                ", _wheelR=" + get_wheelR() +
                ", yearOfManufacture=" + getYearOfManufacture() +
                ", engineCapacity=" + getEngineCapacity() +
                ", options=" + Arrays.toString(get_option()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerCar that = (PassengerCar) o;
        return Arrays.equals(_option, that._option);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(_option);
    }
}


