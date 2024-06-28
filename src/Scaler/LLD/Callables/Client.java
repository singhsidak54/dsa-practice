package Scaler.LLD.Callables;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<ArrayList<Integer>> list = es.submit(new ArrayCreator(n));
        System.out.println(list.get());

        TreeSet<Integer> treeSet = new TreeSet<>();
        System.out.println(treeSet.ceiling(1));
    }
}
