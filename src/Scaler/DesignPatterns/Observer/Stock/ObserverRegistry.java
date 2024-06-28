package Scaler.DesignPatterns.Observer.Stock;

import Scaler.DesignPatterns.Observer.Stock.Observer;

public interface ObserverRegistry {
    void addObserver(Observer observer); // Adds an observer

    void removeObserver(Observer observer); // Removes an observer

    void notifyObservers(String stockName, double currentPrice); // Notifies all observers about a change in the stock price
}
