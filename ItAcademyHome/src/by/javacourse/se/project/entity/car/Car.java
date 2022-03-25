package by.javacourse.se.project.entity.car;

import by.javacourse.se.project.enums.ColorEnum;
import by.javacourse.se.project.enums.ModelEnum;
import by.javacourse.se.project.enums.OptionCarEnum;
import by.javacourse.se.project.enums.WheelREnum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Car {

    private ColorEnum _color;
    private final ModelEnum _model;
    private WheelREnum _wheelR;
    private final Integer yearOfManufacture;
    private final Integer engineCapacity;
    private Set<OptionCarEnum> options;

    public Car(
            ColorEnum color,
            ModelEnum model,
            Integer yearOfManufacture,
            WheelREnum wheelR,
            Integer engineCapacity,
            OptionCarEnum... options
    ) throws NullPointerException {
        if (color == null
                || model == null
                || wheelR == null
                || options == null) {
            throw new NullPointerException();
        }
        this._color = color;
        this._model = model;
        this.yearOfManufacture = yearOfManufacture;
        this._wheelR = wheelR;
        this.engineCapacity = engineCapacity;
        this.options = Arrays.stream(options).collect(Collectors.toSet());
    }

    public Car(
            ColorEnum color,
            ModelEnum model,
            Integer yearOfManufacture,
            WheelREnum wheelR,
            Integer engineCapacity
    ) {
        this._color = color;
        this._model = model;
        this.yearOfManufacture = yearOfManufacture;
        this._wheelR = wheelR;
        this.engineCapacity = engineCapacity;
        this.options = new HashSet<>();
    }

    public void set_color(ColorEnum _color) {
        this._color = _color;
    }

    public void set_wheelR(WheelREnum _wheelR) {
        this._wheelR = _wheelR;
    }

    public void setOptions(Set<OptionCarEnum> options) {
        this.options = options;
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


    public void addOption(OptionCarEnum option) {
        for (OptionCarEnum optionCarEnum : options) {
            if (optionCarEnum.equals(option)) {
                System.out.println("В машине есть такая опция");
                return;
            }
        }

        this.options.add(option);
        System.out.println("Опция " + option.name() + " добавлена на автомобиль.");
    }

    public void removeOption(OptionCarEnum option) {
        int count = 0;
        for (OptionCarEnum optionCarEnum : options) {
            if (optionCarEnum.equals(option)) {
                count++;
                this.options.remove(option);
                System.out.println("Опция " + option.name() + " убрана с автомобиля.");
            }
        }
        if (count == 0) {
            System.out.println("В машине  нет такой опции");
            return;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return _color == car._color
                && _model == car._model
                && _wheelR == car._wheelR
                && Objects.equals(yearOfManufacture, car.yearOfManufacture)
                && Objects.equals(engineCapacity, car.engineCapacity)
                && Objects.equals(options, car.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_color, _model, _wheelR, yearOfManufacture, engineCapacity, options);
    }
}
