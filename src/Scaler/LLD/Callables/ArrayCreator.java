package Scaler.LLD.Callables;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ArrayCreator implements Callable<ArrayList<Integer>> {
    int n;
    public ArrayCreator(int n) {
        this.n = n;
    }

    public ArrayList<Integer> call() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            list.add(i);
        }
        return list;
    }
}
