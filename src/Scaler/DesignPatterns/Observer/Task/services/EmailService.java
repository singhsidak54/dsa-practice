package Scaler.DesignPatterns.Observer.Task.services;

import Scaler.DesignPatterns.Observer.Task.Observer;
import Scaler.DesignPatterns.Observer.Task.Publisher;
import Scaler.DesignPatterns.Observer.Task.utils.NotificationUtils;

public class EmailService implements Observer {

    public EmailService(Publisher p) {
        p.addObserver(this);
    }

    public void sendEmail(Long id, Long taskId) {
        String subject = "New task assigned";
        String message = "Task %s assigned to user %s";
        NotificationUtils.sendEmail(subject, String.format(message, taskId, id));
    }

    @Override
    public void notifyObserver(Long taskId, Long userId) {
        this.sendEmail(userId, taskId);
    }
}