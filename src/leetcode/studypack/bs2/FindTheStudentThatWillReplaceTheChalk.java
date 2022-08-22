package bs2;

public class FindTheStudentThatWillReplaceTheChalk {
    public int chalkReplacer(int[] chalk, int k) {
        if(chalk.length == 1) return 0;

        int n = chalk.length;
        long[] temp = new long[n];
        temp[0] = chalk[0];
        for(int i=1; i<n; i++) {
            temp[i] = temp[i - 1] + chalk[i];
        }

        long t = k;
        t = t % temp[n - 1];

        int l = 0, h = n - 1, m;
        while (l < h) {
            m = l + (h-l)/2;
            if(temp[m] < t) {
                l = m + 1;
            } else {
                h = m;
            }
        }

        return temp[l] == t ? l + 1 : l;
    }
}
