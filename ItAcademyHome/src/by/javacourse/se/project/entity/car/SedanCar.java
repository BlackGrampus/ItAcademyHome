package by.javacourse.se.project.entity.car;

import by.javacourse.se.project.enums.*;

import java.util.Arrays;
import java.util.Objects;

public class SedanCar extends Car {

    private final TrunkEnum _trunk;

    public SedanCar(
            ColorEnum color,
            ModelEnum model,
            Integer yearOfManufacture,
            WheelREnum wheelR,
            Integer engineCapacity,
            TrunkEnum trunk,
            OptionCarEnum... options) {
        super(
                color,
                model,
                yearOfManufacture,
                wheelR,
                engineCapacity,
                options
        );
        this._trunk = trunk;
    }

    public SedanCar(
            ColorEnum color,
            ModelEnum model,
            Integer yearOfManufacture,
            WheelREnum wheelR,
            Integer engineCapacity,
            TrunkEnum trunk
    ) {
        super(
                color,
                model,
                yearOfManufacture,
                wheelR,
                engineCapacity
        );

        this._trunk = trunk;
    }

    public TrunkEnum get_trunk() {
        return _trunk;
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
                + ", trunk "
                + _trunk
                + (super.getOptions().size() == 0
                ? '.' : ", options: " + Arrays.toString(super.getOptions().toArray()) + '.');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SedanCar sedanCar = (SedanCar) o;
        return _trunk == sedanCar._trunk;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_trunk);
    }
}
