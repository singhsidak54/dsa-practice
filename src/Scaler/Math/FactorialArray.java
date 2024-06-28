package Scaler.Math;

import java.util.*;

public class FactorialArray {
    public static int solve(int[] A) {
        Arrays.sort(A);
        int n = A.length, mod = 1_000_000_007;

        int[] primes = new int[A[n - 1] + 1];
        for(int i=2; i<=Math.sqrt(A[n-1]+1); i++) {
            if(primes[i] == -1) continue;

            primes[i] = 0;
            for(int j=i*i; j<=A[n-1]; j+=i) {
                primes[j] = -1;
            }
        }

        int[] primesCount = new int[A[n-1] + 1];
        int count = 0;
        for(int i=2; i<=A[n-1]; i++) {
            if(primes[i] == 0) {
                count++;
            }

            primesCount[i] = count;
        }


        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            int pCount = primesCount[A[i]];
            map.put(pCount, map.getOrDefault(pCount, 0) + 1);
        }

        for(int key : map.keySet()) {
            if(key == 0) continue;
            long current = (long) (Math.pow(2, map.get(key))) - 1;
            ans = (ans + current) % mod;
        }
        return (int)ans;
    }

    public static int solve2(int[] A) {
        Arrays.sort(A);
        int max=A[A.length-1];//finding max of A
        int mod=1000000007;
        boolean[] isPrm= new boolean[max+1];// this array will just store if the no is Prime or not.
        isPrm[0]=isPrm[1]=true;             //All prime no will be left as false, rest set true.
        for(int i=2;i<=Math.sqrt(max+1);i++)
        {
            if(isPrm[i]) continue;// if no is true means it has some divisor, therefore its not prime
            for(int j=i*i;j<=max;j+=i)//if its still false, means no divisor means it is prime
            {
                isPrm[j]=true;//now mark all the multiples of that prime no as true
            }
        }
        int[] Pcount = new int[max+1];//no of prime factors if i! which is same as count of .
        Pcount[2]=1;                   //prime nos till i.
        for(int i=3;i<=max;i++){
            if(!isPrm[i])//if no is prime increment the prime count
                Pcount[i]=Pcount[i-1]+1;
            else
                Pcount[i]=Pcount[i-1];//else the count remains same
        }
        HashMap<Integer,Integer> hm= new HashMap<>();//map to count freq of nos having same count of Prm factors

        for(int i=0;i<A.length;i++)
        {
            int p=Pcount[A[i]];
            hm.put(p,(hm.getOrDefault(p,0)+1));
        }
        long ans=0L;
        for(int k:hm.keySet())
        {
            if(k==0)continue;//nos with zero prime factor cannot be counted as we want non-empty set of prime factors
            long t=(long)(Math.pow(2,hm.get(k))-1);//for n nos of elements with same P-factors .there are 2^n-1 sets.
            ans= (ans+t)%mod;
        }

        return (int)ans;


    }

    public static void main(String[] args) {
        int[] A = {251, 923, 561, 230, 100, 399, 542, 198, 548, 892, 721, 781, 174, 809, 9, 232, 165, 861, 36, 837, 377, 313, 475, 269, 210, 530, 940, 570, 24, 434, 764, 275, 709, 325, 505, 161, 724, 47, 359, 625, 291, 81, 406, 465, 242, 767, 698, 408, 629, 86, 597, 358, 399, 72, 979, 962, 603, 919, 884, 627, 353, 1, 254, 414, 678, 111, 575, 755, 511, 287, 380, 802, 720, 138, 620, 314, 905, 670, 74, 886, 756, 671, 244, 508, 744, 224, 822, 347, 495, 706, 326, 201, 707, 580, 615, 386, 43, 543, 141, 554};
        System.out.println(solve(A));
        System.out.println(solve2(A));
    }
}
