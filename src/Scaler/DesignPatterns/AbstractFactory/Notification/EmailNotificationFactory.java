package Scaler.DesignPatterns.AbstractFactory.Notification;

import Scaler.DesignPatterns.AbstractFactory.Notification.notification.EmailNotification;
import Scaler.DesignPatterns.AbstractFactory.Notification.notification.Notification;
import Scaler.DesignPatterns.AbstractFactory.Notification.sender.EmailNotificationSender;
import Scaler.DesignPatterns.AbstractFactory.Notification.sender.NotificationSender;
import Scaler.DesignPatterns.AbstractFactory.Notification.template.EmailNotificationTemplate;
import Scaler.DesignPatterns.AbstractFactory.Notification.template.NotificationTemplate;

public class EmailNotificationFactory extends NotificationFactory {
    @Override
    public NotificationType notificationType() {
        return NotificationType.EMAIL;
    }

    @Override
    public Notification createNotification(String recipient, String sender, NotificationTemplate template) {
        return new EmailNotification(recipient, sender, template);
    }

    @Override
    public NotificationSender createNotificationSender(Notification notification) {
        return new EmailNotificationSender(notification);
    }

    @Override
    public NotificationTemplate createNotificationTemplate(String message) {
        return new EmailNotificationTemplate(message);
    }
}
