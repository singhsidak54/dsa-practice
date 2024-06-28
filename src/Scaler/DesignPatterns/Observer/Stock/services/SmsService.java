package Scaler.DesignPatterns.Observer.Stock.services;

import Scaler.DesignPatterns.Observer.Stock.Observer;
import Scaler.DesignPatterns.Observer.Stock.utils.NotificationUtils;

public class SmsService implements Observer {
    public void sendSMS(String stockName, double currentPrice) {
        String subject = "Price update for " + stockName;
        String message = "New price is " + currentPrice;
        NotificationUtils.sendSms(subject, message);
    }

    @Override
    public void notifyObserver(String stockName, double currentPrice) {
        sendSMS(stockName, currentPrice);
    }
}