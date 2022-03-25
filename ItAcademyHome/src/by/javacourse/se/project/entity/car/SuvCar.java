package by.javacourse.se.project.entity.car;

import by.javacourse.se.project.enums.ColorEnum;
import by.javacourse.se.project.enums.ModelEnum;
import by.javacourse.se.project.enums.OptionCarEnum;
import by.javacourse.se.project.enums.WheelREnum;

import java.util.Arrays;
import java.util.Objects;

public class SuvCar extends Car {

    private final String nickNameCar;

    public SuvCar(
            ColorEnum color,
            ModelEnum model,
            Integer yearOfManufacture,
            WheelREnum wheelR,
            Integer engineCapacity,
            String nickNameCar,
            OptionCarEnum... options) {
        super(
                color,
                model,
                yearOfManufacture,
                wheelR,
                engineCapacity,
                options
        );
        this.nickNameCar = nickNameCar;
    }

    public SuvCar(
            ColorEnum color,
            ModelEnum model,
            Integer yearOfManufacture,
            WheelREnum wheelR,
            Integer engineCapacity,
            String nickNameCar
    ) {
        super(
                color,
                model,
                yearOfManufacture,
                wheelR,
                engineCapacity
        );
        this.nickNameCar = nickNameCar;
    }

    public String getNickNameCar() {
        return nickNameCar;
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
                + ", nickName "
                + nickNameCar
                + (super.getOptions().size() == 0
                ? '.' : ", options: " + Arrays.toString(super.getOptions().toArray()) + '.');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SuvCar suvCar = (SuvCar) o;
        return Objects.equals(nickNameCar, suvCar.nickNameCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nickNameCar);
    }
}
