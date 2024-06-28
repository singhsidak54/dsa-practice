package Scaler.DesignPatterns.AbstractFactory.Notification;

import Scaler.DesignPatterns.AbstractFactory.Notification.notification.Notification;
import Scaler.DesignPatterns.AbstractFactory.Notification.sender.NotificationSender;
import Scaler.DesignPatterns.AbstractFactory.Notification.template.NotificationTemplate;

public abstract class NotificationFactory {
    public abstract NotificationType notificationType();
    public abstract Notification createNotification(String recipient, String sender, NotificationTemplate template);

    public abstract NotificationSender createNotificationSender(Notification notification);

    public abstract NotificationTemplate createNotificationTemplate(String message);
}