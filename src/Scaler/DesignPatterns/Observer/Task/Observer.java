package Scaler.DesignPatterns.Observer.Task;

public interface Observer {
    void notifyObserver(Long taskId, Long userId); // Notifies the observer about a task assignment
}
