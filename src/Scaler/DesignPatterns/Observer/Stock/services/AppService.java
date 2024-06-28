package Scaler.DesignPatterns.Observer.Stock.services;

import Scaler.DesignPatterns.Observer.Stock.Observer;
import Scaler.DesignPatterns.Observer.Stock.utils.NotificationUtils;

public class AppService implements Observer {
    public void sendPush(String stockName, double currentPrice) {
        String subject = "Price update for " + stockName;
        String message = "New price is " + currentPrice;
        NotificationUtils.sendPush(subject, message);
    }

    @Override
    public void notifyObserver(String stockName, double currentPrice) {
        sendPush(stockName, currentPrice);
    }
}