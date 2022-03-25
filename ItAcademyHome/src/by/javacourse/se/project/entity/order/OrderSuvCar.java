package by.javacourse.se.project.entity.order;

import by.javacourse.se.project.enums.ColorEnum;
import by.javacourse.se.project.enums.ModelEnum;
import by.javacourse.se.project.enums.OptionCarEnum;
import by.javacourse.se.project.enums.WheelREnum;

import java.util.Arrays;

public class OrderSuvCar extends OrderCar {

    private final String nickNameCar;

    public OrderSuvCar(
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

    public OrderSuvCar(
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
}
