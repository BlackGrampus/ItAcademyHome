package by.javacourse.se.project.factories;

import by.javacourse.se.project.enums.ColorEnum;
import by.javacourse.se.project.enums.ModelEnum;
import by.javacourse.se.project.enums.WheelREnum;
import by.javacourse.se.project.services.CarServices;

public class CarFactories {

    private final SedanCarFactory sedanCarFactory;
    private final SportCarFactory sportCarFactory;
    private final SuvCarFactory suvCarFactory;

    private final CarServices services;

    public CarFactories(CarServices services) {
        this.services = services;
        this.sedanCarFactory = new SedanCarFactory(ColorEnum.values(),
                ModelEnum.values(),
                WheelREnum.values(),
                new Integer[]{1600, 1800, 2000},
                services);
        this.sportCarFactory = new SportCarFactory(ColorEnum.values(),
                ModelEnum.values(),
                WheelREnum.values(),
                new Integer[]{1600, 1800, 2000},
                services);
        this.suvCarFactory = new SuvCarFactory(ColorEnum.values(),
                ModelEnum.values(),
                WheelREnum.values(),
                new Integer[]{1600, 1800, 2000},
                services);
    }

    public SedanCarFactory getSedanCarFactory() {
        return sedanCarFactory;
    }

    public SportCarFactory getSportCarFactory() {
        return sportCarFactory;
    }

    public SuvCarFactory getSuvCarFactory() {
        return suvCarFactory;
    }
}
