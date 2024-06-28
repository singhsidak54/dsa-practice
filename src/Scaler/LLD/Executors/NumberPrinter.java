package Scaler.LLD.Executors;

class NumberPrinter implements Runnable {
    int num;
    public NumberPrinter(int n) {
        this.num = n;
    }

    @Override
    public void run() {
        System.out.println(this.num + " " + Thread.currentThread().getName());
    }
}
