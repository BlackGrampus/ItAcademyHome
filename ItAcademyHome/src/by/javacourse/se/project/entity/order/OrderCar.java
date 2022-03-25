package by.javacourse.se.project.entity.order;

import by.javacourse.se.project.enums.ColorEnum;
import by.javacourse.se.project.enums.ModelEnum;
import by.javacourse.se.project.enums.OptionCarEnum;
import by.javacourse.se.project.enums.WheelREnum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class OrderCar {

    private final ColorEnum _color;
    private final ModelEnum _model;
    private final WheelREnum _wheelR;
    private final Integer yearOfManufacture;
    private final Integer engineCapacity;
    private final Set<OptionCarEnum> options;

    public OrderCar(
            ColorEnum color,
            ModelEnum model,
            Integer yearOfManufacture,
            WheelREnum wheelR,
            Integer engineCapacity
    ) throws NullPointerException {
        if (color == null
                || model == null
                || wheelR == null) {
            throw new NullPointerException();
        }
        this._color = color;
        this._model = model;
        this.yearOfManufacture = yearOfManufacture;
        this._wheelR = wheelR;
        this.engineCapacity = engineCapacity;
        this.options = new HashSet<>();
    }

    public OrderCar(
            ColorEnum _color,
            ModelEnum _model,
            Integer yearOfManufacture,
            WheelREnum _wheelR,
            Integer engineCapacity,
            OptionCarEnum... options
    ) {
        this._color = _color;
        this._model = _model;
        this.yearOfManufacture = yearOfManufacture;
        this._wheelR = _wheelR;
        this.engineCapacity = engineCapacity;
        this.options = Arrays.stream(options).collect(Collectors.toSet());
    }

    public ColorEnum get_color() {
        return _color;
    }

    public ModelEnum get_model() {
        return _model;
    }

    public WheelREnum get_wheelR() {
        return _wheelR;
    }

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public Set<OptionCarEnum> getOptions() {
        return options;
    }
}
