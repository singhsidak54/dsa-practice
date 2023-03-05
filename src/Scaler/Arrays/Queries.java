package Scaler.Arrays;

import java.util.ArrayList;

public class Queries {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        int n = A.size(), m = A.get(0).size();
        int mod = 1_000_000_007;
        long[][] sum = new long[n + 1][m + 1];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sum[i + 1][j + 1] = (A.get(i).get(j) + sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + mod) % mod;
            }
        }


        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<B.size(); i++) {
            int tR = B.get(i), tC = C.get(i), bR = D.get(i), bC = E.get(i);
            long query = sum[bR][bC] - sum[tR - 1][bC] - sum[bR][tC - 1] + sum[tR - 1][tC - 1];

            while(query < 0) {
                query += mod;
            }

            result.add((int)(query % mod));
        }

        return result;
    }
}
