package by.javacourse.se.project.entity.order;

import by.javacourse.se.project.enums.ColorEnum;
import by.javacourse.se.project.enums.ModelEnum;
import by.javacourse.se.project.enums.OptionCarEnum;
import by.javacourse.se.project.enums.WheelREnum;

import java.util.Arrays;

public class OrderSportCar extends OrderCar {

    private final Integer spoilerSize;

    public OrderSportCar(
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

    public OrderSportCar(
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
}
