package by.javacourse.se.homework3.entity;

import by.javacourse.se.homework3.constants.Color;
import by.javacourse.se.homework3.constants.Model;
import by.javacourse.se.homework3.constants.WheelR;

import java.util.Objects;

public abstract class Car {

    protected  Color _color;
    private final Model _model;
    protected  WheelR _wheelR;
    private final Integer yearOfManufacture;
    private final Integer engineCapacity;

    protected Car(Color color, Model model, Integer yearOfManufacture,
                  WheelR wheelR, Integer engineCapacity) {
        this._color = color;
        this._model = model;
        this.yearOfManufacture = yearOfManufacture;
        this._wheelR = wheelR;
        this.engineCapacity = engineCapacity;

    }

    protected Color get_color() {
        return _color;
    }

    protected void set_color(Color _color) {
        this._color = _color;
    }

    protected Model get_model() {
        return _model;
    }

    protected WheelR get_wheelR() {
        return _wheelR;
    }

    protected void set_wheelR(WheelR _wheelR) {
        this._wheelR = _wheelR;
    }

    protected Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    protected Integer getEngineCapacity() {
        return engineCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return _color == car._color && _model == car._model && _wheelR == car._wheelR && Objects.equals(yearOfManufacture, car.yearOfManufacture) && Objects.equals(engineCapacity, car.engineCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_color, _model, _wheelR, yearOfManufacture, engineCapacity);
    }
}
