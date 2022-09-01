package gt1;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n+1];

        for(int[] edge : trust) {
            trustCount[edge[0]]--;
            trustCount[edge[1]]++;
        }

        for(int i=1; i<=n; i++) {
            if(trustCount[i] == n-1) {
                return i;
            }
        }

        return -1;
    }
}
