package Scaler.DesignPatterns.AbstractFactory.Notification.template;

import Scaler.DesignPatterns.AbstractFactory.Notification.NotificationType;

public abstract class NotificationTemplate {
    private String message;

    public NotificationTemplate(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public abstract String applyTemplate();
    public abstract NotificationType notificationType();

}