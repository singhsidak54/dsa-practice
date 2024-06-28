package Scaler.DesignPatterns.Observer.Stock.services;

import Scaler.DesignPatterns.Observer.Stock.Observer;
import Scaler.DesignPatterns.Observer.Stock.utils.NotificationUtils;

public class EmailService implements Observer {
    public void sendEmail(String stockName, double currentPrice) {
        String subject = "Price update for " + stockName;
        String message = "New price is " + currentPrice;
        NotificationUtils.sendEmail(subject, message);
    }

    @Override
    public void notifyObserver(String stockName, double currentPrice) {
        sendEmail(stockName, currentPrice);
    }
}