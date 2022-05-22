package algo2;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> provinceQ = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                ans++;
                provinceQ.add(i);
                visitNeighbours(isConnected, visited, provinceQ);
            }
        }
        return ans;
    }

    public static void visitNeighbours(int[][] isConnected, boolean[] visited, Queue<Integer> provinceQ) {
        while (!provinceQ.isEmpty()) {
            int province = provinceQ.poll();
            visited[province] = true;
            for(int i=0; i<isConnected.length; i++) {
                if(i != province && !visited[i] && isConnected[province][i] == 1) {
                    provinceQ.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] cities = {{1,0,0}, {0,1,0},{0,0,1}};
        System.out.println(findCircleNum(cities));
    }
}
