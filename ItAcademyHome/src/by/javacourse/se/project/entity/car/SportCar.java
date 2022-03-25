package by.javacourse.se.project.entity.car;

import by.javacourse.se.project.enums.*;

import java.util.Arrays;
import java.util.Objects;

public class SportCar extends Car {

    private final Integer spoilerSize;

    public SportCar(
            ColorEnum color,
            ModelEnum model,
            Integer yearOfManufacture,
            WheelREnum wheelR,
            Integer engineCapacity,
            Integer spoilerSize,
            OptionCarEnum... options) {
        super(
                color,
                model,
                yearOfManufacture,
                wheelR,
                engineCapacity,
                options
        );
        this.spoilerSize = spoilerSize;
    }

    public SportCar(
            ColorEnum color,
            ModelEnum model,
            Integer yearOfManufacture,
            WheelREnum wheelR,
            Integer engineCapacity,
            Integer spoilerSize
    ) {
        super(
                color,
                model,
                yearOfManufacture,
                wheelR,
                engineCapacity
        );
        this.spoilerSize = spoilerSize;
    }

    public Integer getSpoilerSize() {
        return spoilerSize;
    }

    @Override
    public String toString() {
        return "model "
                + super.get_model()
                + ", "
                + super.getYearOfManufacture()
                + " year, engine capacity "
                + super.getEngineCapacity()
                + ", color "
                + super.get_color()
                + ", wheel size "
                + super.get_wheelR()
                + ", spoiler size "
                + spoilerSize
                + (super.getOptions().size() == 0
                ? '.' : ", options: " + Arrays.toString(super.getOptions().toArray()) + '.');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SportCar sportCar = (SportCar) o;
        return Objects.equals(spoilerSize, sportCar.spoilerSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), spoilerSize);
    }
}
