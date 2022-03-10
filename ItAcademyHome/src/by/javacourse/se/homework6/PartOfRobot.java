package by.javacourse.se.homework6;

public enum PartOfRobot {

    RIGHT_ARM(0),
    LEFT_ARM(1),
    RIGHT_LEG(2),
    LEFT_LEG(3),
    BODY(4),
    HEAD(5);

    private final int number;

    PartOfRobot(int value) {
        this.number = value;
    }

    public int getNumber() {
        return number;
    }
}