package daily.jan23;

public class Day23FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] degrees = new int[n];
        for(int[] trustItem : trust) {
            degrees[trustItem[1]]++;
            degrees[trustItem[0]]--;
        }

        for(int i=0; i<n; i++) {
            if(degrees[i] == n-1) {
                return i;
            }
        }

        return -1;
    }
}
