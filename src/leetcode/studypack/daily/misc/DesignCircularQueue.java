package daily.misc;

public class DesignCircularQueue {
    int[] queue;
    int front, rear;

    public DesignCircularQueue(int k) {
        this.queue = new int[k];
        front = 0;
        rear = -1;
    }

    public boolean enQueue(int value) {
        int newIndex = (this.rear + 1) % this.queue.length;
        if(this.rear != -1 && this.front == newIndex) {
            return false;
        }

        this.queue[newIndex] = value;

        if(this.rear == -1) {
            this.front = 0;
        }

        this.rear = newIndex;
        return true;
    }

    public boolean deQueue() {
        if(this.rear == -1) return false;
        if(this.front == this.rear) {
            this.rear = -1;
        }

        this.front = (this.front + 1) % this.queue.length;
        return true;
    }

    public int Front() {
        if(this.rear == -1) return -1;
        return this.queue[this.front];
    }

    public int Rear() {
        if(this.rear == -1) return -1;
        return this.queue[this.rear];
    }

    public boolean isEmpty() {
        return this.rear == -1;
    }

    public boolean isFull() {
        int newIndex = (this.rear + 1) % this.queue.length;
        return this.rear != -1 && this.front == newIndex;
    }
}
