package misc;

public class MinimumOperationsToMakeArrayEqual {
    public static int calculateNum(int n) {
        return 2 * n + 1;
    }

    public static int minOperations(int n) {
        int pivot;
        if(n % 2 == 0) {
            pivot = (calculateNum(n/2) + calculateNum((n-1)/2))/2;
        } else {
            pivot = calculateNum(n/2);
        }

        int cost = 0;
        for(int i=0; i<n/2; i++) {
            cost += pivot - calculateNum(i);
        }

        return cost;
    }

    public static int triangleSum(int n) {
        return n * (n + 1)/2;
    }

    public static int minOperationsMaths(int n) {
        if(n % 2 == 0) {
            return 2 * triangleSum((n-2)/2) + n/2;
        }
        return 2 * triangleSum((n-1)/2);
    }

    public static void main(String[] args) {
        System.out.println(minOperationsMaths(3));
    }
}
