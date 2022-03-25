package by.javacourse.se.project.entity;

import by.javacourse.se.project.entity.car.Car;

import java.util.LinkedList;

public class StorageCar<T extends Car> {
    private T element;
    private LinkedList<T> storage = new LinkedList<>();

    public void addToStorage(T element) {
        synchronized (storage) {
            storage.add(element);
        }
    }

    public void diffToStorage(T element) {
        synchronized (storage) {
            storage.removeFirstOccurrence(element);
        }
    }

    public LinkedList<T> getStorage() {
        return storage;
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
