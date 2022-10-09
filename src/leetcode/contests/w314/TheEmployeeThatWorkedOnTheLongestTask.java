package contests.w314;

public class TheEmployeeThatWorkedOnTheLongestTask {
    public int hardestWorker(int n, int[][] logs) {
        int ans = logs[0][0], maxTimeTaken = logs[0][1];
        for(int i=1; i<logs.length; i++) {
            if(logs[i][1] - logs[i-1][1] > maxTimeTaken) {
                ans = logs[i][0];
                maxTimeTaken = logs[i][1] - logs[i-1][1];
            } else if (logs[i][1] - logs[i-1][1] == maxTimeTaken) {
                ans = Math.min(ans, logs[i][0]);
            }
        }
        return ans;
    }
}
