package Scaler.LLD.Threads.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Client {

    static class Pair {
        int a, b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        for(int i=1; i<=n; i++) {
//            Thread t = new Thread(new TableCreator(i));
//            t.start();
//        }

        Pair one = new Pair(10,20);
        Pair two = new Pair(30, 40);

        swap(one, two);
        System.out.println(one.a + " " + one.b);
        System.out.println(two.a + " " + two.b);
    }


    public static void swap(Pair a, Pair b) {
        Pair temp = a;
        a = b;
        b = temp;
    }
    static int fun(int a, int b) {
        return a + b;
    }

    static String fun(String a, String b) {
        return "";
    }

    static int fun(int a, int b, int c) {
        return 0;
    }

    static int fun(int... arr) {
        return arr[0];
    }
}
