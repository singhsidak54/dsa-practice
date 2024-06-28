package Scaler.LLD.Threads.Exercise;

public class Adder implements Runnable {
    int a;
    int b;
    public Adder(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public void run() {
        System.out.println(a + b);
    }
}
