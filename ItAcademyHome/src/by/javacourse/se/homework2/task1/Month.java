package by.javacourse.se.homework2.task1;

public enum Month {
    JANUARY("January", 1),
    FEBRUARY("February", 2),
    MARCH("March", 3),
    APRIL("April", 4),
    MAY("May", 5),
    JUNE("June", 6),
    JULY("July", 7),
    AUGUST("August", 8),
    SEPTEMBER("September", 9),
    OCTOBER("October", 10),
    NOVEMBER("November", 11),
    DECEMBER("December", 12);

    private final String name;
    private final int number;

    Month(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public static String getNameByNumber(int number) {
        for (Month month : values()) {
            if (month.number == number) {
                return month.name;
            }
        }
        return null;
    }

    public static int getNumberByName(String name) {
        for (Month month : values()) {
            if(month.name.equals(name)) {
                return month.number;
            }
        }
        return 0;
    }
}

