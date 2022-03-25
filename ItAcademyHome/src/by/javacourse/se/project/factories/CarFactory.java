package by.javacourse.se.project.factories;

import by.javacourse.se.project.entity.car.Car;
import by.javacourse.se.project.entity.order.OrderCar;
import by.javacourse.se.project.services.*;
import by.javacourse.se.project.enums.*;

public abstract class CarFactory {

    private final ColorEnum[] _color;
    private final ModelEnum[] _model;
    private final WheelREnum[] _wheelR;
    private final Integer[] engineCapacity;

    private final CarServices services;

    public CarFactory(
            ColorEnum[] color,
            ModelEnum[] model,
            WheelREnum[] wheelR,
            Integer[] engineCapacity,
            CarServices services
    ) throws NullPointerException {
        if (services == null
                || color == null
                || model == null
                || wheelR == null
                || engineCapacity == null) {
            throw new NullPointerException();
        }
        this._color = color;
        this._model = model;
        this._wheelR = wheelR;
        this.engineCapacity = engineCapacity;
        this.services = services;
    }

    public ColorEnum[] get_color() {
        return _color;
    }

    public ModelEnum[] get_model() {
        return _model;
    }

    public WheelREnum[] get_wheelR() {
        return _wheelR;
    }

    public Integer[] getEngineCapacity() {
        return engineCapacity;
    }

    public CarServices getServices() {
        return services;
    }

    public abstract void printEngineCapacities();

    public abstract void printModels();

    public abstract void printColors();

    public abstract void printWheelR();
}

