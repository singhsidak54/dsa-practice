package Scaler.DesignPatterns.Observer.Task.services;

import Scaler.DesignPatterns.Observer.Task.Observer;
import Scaler.DesignPatterns.Observer.Task.Publisher;
import Scaler.DesignPatterns.Observer.Task.utils.NotificationUtils;

public class SlackService implements Observer {

    public SlackService(Publisher p) {
        p.addObserver(this);
    }

    public void sendSlack(Long id, Long taskId) {
        String subject = "New task assigned";
        String message = "Task %s assigned to user %s";
        NotificationUtils.sendSlack(subject, String.format(message, taskId, id));
    }

    @Override
    public void notifyObserver(Long taskId, Long userId) {
        this.sendSlack(userId, taskId);
    }
}