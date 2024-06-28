package Scaler.LLD.Threads.Exercise;

public class TableCreator implements  Runnable {
    int n;
    public TableCreator(int n) {
        this.n = n;
    }

    public void run() {
        for(int i=1; i<=10; i++) {
            System.out.println(n + " times " + i + " is " + i * n);
        }
    }
}
