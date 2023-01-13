package daily.jan23;

import java.util.*;

public class Day8NumberOfNodesInTheSubTreeWithTheSameLabel {
    static int[] ans;
    public static void countSubTrees(List<List<Integer>> neighbours, int vertex, int parent, String labels, HashMap<Character, Set<Integer>> seenAt) {
        char label = labels.charAt(vertex);
        Set<Integer> labelSeenSet = seenAt.getOrDefault(label, new HashSet<>());
        for(int ancestor : labelSeenSet) {
            ans[ancestor]++;
        }

        ans[vertex] = 1;
        labelSeenSet.add(vertex);
        seenAt.put(label, labelSeenSet);

        // make call to each child
        for(int child : neighbours.get(vertex)) {
            if(child == parent) continue;
            countSubTrees(neighbours, child, vertex, labels, seenAt);
        }

        labelSeenSet = seenAt.get(label);
        labelSeenSet.remove(vertex);
        if(labelSeenSet.size() == 0) {
            seenAt.remove(label);
        } else {
            seenAt.put(label, labelSeenSet);
        }
    }

    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        HashMap<Character, Set<Integer>> seenAt = new HashMap<>();
        ans = new int[n];
        List<List<Integer>> neighbours = new ArrayList<>();
        for(int i=0; i<n; i++) {
            neighbours.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            neighbours.get(edge[0]).add(edge[1]);
            neighbours.get(edge[1]).add(edge[0]);
        }

        countSubTrees(neighbours, 0, -1, labels, seenAt);
        return ans;
    }

    public static int[] countSubTreesOptimised(List<List<Integer>> neighbours, int vertex, int parent, String labels) {
        int[] nodesMap = new int[26];
        nodesMap[labels.charAt(vertex) - 'a']++;

        for(int child : neighbours.get(vertex)) {
            if(child == parent) continue;
            int[] childLabels = countSubTreesOptimised(neighbours, child, vertex, labels);

            for(int i=0; i<26; i++) {
                nodesMap[i] += childLabels[i];
            }
        }

        ans[vertex] = nodesMap[labels.charAt(vertex) - 'a'];
        return nodesMap;
    }

    public static int[] countSubTreesOptimised(int n, int[][] edges, String labels) {
        ans = new int[n];
        List<List<Integer>> neighbours = new ArrayList<>();
        for(int i=0; i<n; i++) {
            neighbours.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            neighbours.get(edge[0]).add(edge[1]);
            neighbours.get(edge[1]).add(edge[0]);
        }

        countSubTreesOptimised(neighbours, 0, -1, labels);
        return ans;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        System.out.println(Arrays.toString(countSubTrees(7, edges, "abaedcd")));
    }
}
