package Scaler.DesignPatterns.Observer.Weather;

import java.util.ArrayList;
import java.util.List;

// The Publisher abstract class implements the ObserverRegistry interface and provides a default implementation for managing observers.
public abstract class Publisher implements ObserverRegistry {
    private List<Observer> observers = new ArrayList<>(); // The list of observers

    public void addObserver(Observer observer) {
        observers.add(observer); // Adds an observer to the list
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer); // Removes an observer from the list
    }

    public void notifyObservers(double value) {
        observers.forEach(observer -> observer.notifyObserver(value)); // Notifies all observers about a change in value
    }
}