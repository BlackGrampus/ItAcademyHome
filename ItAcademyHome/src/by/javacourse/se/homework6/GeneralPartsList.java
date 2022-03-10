package by.javacourse.se.homework6;

import java.util.LinkedList;
import java.util.List;

public class GeneralPartsList {

    private final List<PartOfRobot> parts_list;

    public GeneralPartsList() {
        parts_list = new LinkedList<>();
    }

    public PartOfRobot getPart(PartOfRobot part) {
        synchronized (parts_list) {
            if (parts_list.contains(part)) {
                PartOfRobot result = part;
                parts_list.remove(part);
                return result;
            } else
                return null;
        }
    }

    public void addPart(PartOfRobot part) {
        synchronized (parts_list) {
            parts_list.add(part);
            System.out.println("В наличии  части робота: " + parts_list);
        }
    }
}