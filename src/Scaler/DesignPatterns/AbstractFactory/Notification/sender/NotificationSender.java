package Scaler.DesignPatterns.AbstractFactory.Notification.sender;

import Scaler.DesignPatterns.AbstractFactory.Notification.NotificationType;
import Scaler.DesignPatterns.AbstractFactory.Notification.notification.Notification;

public abstract class NotificationSender {
    private final Notification notification;

    public NotificationSender(Notification notification) {
        this.notification = notification;
    }

    public Notification getNotification() {
        return notification;
    }

    public abstract void send();

    public abstract NotificationType notificationType();

}