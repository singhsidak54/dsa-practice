package Scaler.DesignPatterns.Observer.Task;

public class TaskManager extends Publisher {

    public void assignTask(Long taskId, Long userId) {
        this.notifyObservers(taskId, userId);
    }
}