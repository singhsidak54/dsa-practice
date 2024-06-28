package Scaler.LLD.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=0; i<10000; i++) {
            NumberPrinter np = new NumberPrinter(i);
            es.execute(np);
        }
    }
}
