package Scaler.DesignPatterns.Factory.Notification;

public abstract class Notification {

    String recipient;
    String message;

    public abstract NotificationType notificationType();

    public abstract String getRecipient();

    public abstract String getMessage();

    public abstract void sendNotification();
}