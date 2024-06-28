package Scaler.DesignPatterns.Factory.Notification;

public class NotificationFactory {
    public static Notification createNotification(NotificationType type, String recipient, String sender, String message) {
        switch (type) {
            case EMAIL:
                return new EmailNotification(recipient, sender, message);
            case SMS:
                return new SmsNotification(recipient, message);
            case PUSH:
                return new PushNotification(recipient, message);
            default:
                return null;
        }
    }
}
