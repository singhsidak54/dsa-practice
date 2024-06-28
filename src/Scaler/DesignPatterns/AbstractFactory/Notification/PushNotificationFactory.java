package Scaler.DesignPatterns.AbstractFactory.Notification;

import Scaler.DesignPatterns.AbstractFactory.Notification.notification.Notification;
import Scaler.DesignPatterns.AbstractFactory.Notification.notification.PushNotification;
import Scaler.DesignPatterns.AbstractFactory.Notification.sender.NotificationSender;
import Scaler.DesignPatterns.AbstractFactory.Notification.sender.PushNotificationSender;
import Scaler.DesignPatterns.AbstractFactory.Notification.template.NotificationTemplate;
import Scaler.DesignPatterns.AbstractFactory.Notification.template.PushNotificationTemplate;

public class PushNotificationFactory extends NotificationFactory {
    @Override
    public NotificationType notificationType() {
        return NotificationType.PUSH;
    }

    @Override
    public Notification createNotification(String recipient, String sender, NotificationTemplate template) {
        return new PushNotification(recipient, template);
    }

    @Override
    public NotificationSender createNotificationSender(Notification notification) {
        return new PushNotificationSender(notification);
    }

    @Override
    public NotificationTemplate createNotificationTemplate(String message) {
        return new PushNotificationTemplate(message);
    }
}
