package Scaler.Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class LargestDistanceBetweenNodesOfATree {
    int max;

    public int dfs(HashMap<Integer, ArrayList<Integer>> adjList, int curr, int parent) {
        int largest = 0, secondLargest = 0;
        for(int next : adjList.get(curr)) {
            if(next == parent) continue;
            int child = dfs(adjList, next, curr);
            if(child > largest) {
                secondLargest = largest;
                largest = child;
            } else if(child > secondLargest) {
                secondLargest = child;
            }
        }

        max = Math.max(max, 1 + largest + secondLargest);
        return 1 + largest;
    }

    public int solve(int[] A) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for(int i=0; i<A.length; i++) {
            adjList.put(i, new ArrayList<>());
        }

        int root = 0;
        for(int i=0; i<A.length; i++) {
            if(A[i] == -1) {
                root = i;
                continue;
            }
            adjList.get(A[i]).add(i);
            adjList.get(i).add(A[i]);
        }

        max = 0;
        dfs(adjList, root, root);
        return max - 1;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 0};
        LargestDistanceBetweenNodesOfATree obj = new LargestDistanceBetweenNodesOfATree();
        System.out.println(obj.solve(arr));
    }
}
