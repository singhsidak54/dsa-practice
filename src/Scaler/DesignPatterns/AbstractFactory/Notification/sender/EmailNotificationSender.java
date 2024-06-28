package Scaler.DesignPatterns.AbstractFactory.Notification.sender;

import Scaler.DesignPatterns.AbstractFactory.Notification.NotificationType;
import Scaler.DesignPatterns.AbstractFactory.Notification.notification.Notification;

public class EmailNotificationSender extends NotificationSender {

    public EmailNotificationSender(Notification notification) {
        super(notification);
    }

    @Override
    public void send() {
        System.out.println("Sending Email notification to " + getNotification().getRecipient());
    }

    @Override
    public NotificationType notificationType() {
        return NotificationType.EMAIL;
    }
}