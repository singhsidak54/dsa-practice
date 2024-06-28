package Scaler.LLD.Callables;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {
    Node root;
    ExecutorService es;
    public TreeSizeCalculator(Node root, ExecutorService es) {
        this.root = root;
        this.es = es;
    }

    @Override
    public Integer call() throws ExecutionException, InterruptedException {
        if (this.root == null) return 0;

        TreeSizeCalculator lt = new TreeSizeCalculator(this.root.left, this.es);
        TreeSizeCalculator rt = new TreeSizeCalculator(this.root.right, this.es);

        Future<Integer> lF = es.submit(lt);
        Future<Integer> rF = es.submit(rt);

        return 1 + lF.get() + rF.get();
    }
}
