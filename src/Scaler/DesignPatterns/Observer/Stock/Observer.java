package Scaler.DesignPatterns.Observer.Stock;


public interface Observer {
    void notifyObserver(String stockName, double currentPrice); // Notifies the observer about a change in the stock price
}