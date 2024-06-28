package Scaler.DesignPatterns.AbstractFactory.Notification.sender;

import Scaler.DesignPatterns.AbstractFactory.Notification.NotificationType;
import Scaler.DesignPatterns.AbstractFactory.Notification.notification.Notification;

public class PushNotificationSender extends NotificationSender {

    public PushNotificationSender(Notification notification) {
        super(notification);
    }

    @Override
    public void send() {
        System.out.println("Sending Push notification to " + getNotification().getRecipient());
    }

    @Override
    public NotificationType notificationType() {
        return NotificationType.PUSH;
    }
}