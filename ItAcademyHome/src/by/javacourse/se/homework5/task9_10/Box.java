package by.javacourse.se.homework5.task9_10;

import java.io.Serializable;
import java.util.Objects;

public class Box implements Serializable, Comparable<Box>{

    private final int x;
    private final int y;
    private final int z;

    public Box(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
    public int getVolume() {
        return x * y * z;
    }

    @Override
    public int compareTo(Box anotherBox) {

        if (getVolume() == anotherBox.getVolume()) {
            return 0;
        } else if (getVolume() > anotherBox.getVolume()) {
            return -1;
        } else {
            return 1;
        }

    }

    @Override
    public String toString() {
        return "Box{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", volume=" + getVolume() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return x == box.x && y == box.y && z == box.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
