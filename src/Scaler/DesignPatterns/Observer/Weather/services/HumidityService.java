package Scaler.DesignPatterns.Observer.Weather.services;

import Scaler.DesignPatterns.Observer.Weather.Observer;
import Scaler.DesignPatterns.Observer.Weather.utils.NotificationUtils;

public class HumidityService implements Observer {
    public void trigger(double value) {
        NotificationUtils.sendNotification("New value is " + value);
    }

    @Override
    public void notifyObserver(double value) {
        trigger(value);
    }
}
