package by.javacourse.se.homework3.entity;

import java.util.LinkedList;

public class Storage<T  extends Car> {
    private T element;
    private LinkedList<T> storage = new LinkedList<>();

    public void addToStorage(T element){
        storage.add(element);
    }

    public void diffToStorage(T element){
        storage.removeFirstOccurrence(element);
    }

    public LinkedList<T> getStorage() {
        return storage;
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
