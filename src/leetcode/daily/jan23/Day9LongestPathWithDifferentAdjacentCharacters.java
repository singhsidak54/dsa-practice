package daily.jan23;

import java.util.ArrayList;
import java.util.List;

public class Day9LongestPathWithDifferentAdjacentCharacters {
    int ans;
    class Node {
        char label;
        ArrayList<Integer> children;
        public Node(char label) {
            this.label = label;
            this.children = new ArrayList<>();
        };
    }

    public int dfs(List<Node> nodes, int node) {
        int currAns = 1;
        Node curr = nodes.get(node);
        int firstMaxPath = 0, secondMaxPath = 0;
        for(int child : curr.children) {
            Node childNode = nodes.get(child);
            if(childNode.label == curr.label) {
                dfs(nodes, child);
            } else {
                int childAns = dfs(nodes, child);
                if(childAns > firstMaxPath) {
                    secondMaxPath = firstMaxPath;
                    firstMaxPath = childAns;
                } else if (childAns > secondMaxPath) {
                    secondMaxPath = childAns;
                }
            }
        }

        ans = Math.max(ans, currAns + firstMaxPath + secondMaxPath);
        return currAns + firstMaxPath;
    }

    public int longestPath(int[] parent, String s) {
        ans = 0;

        // build tree
        List<Node> nodes = new ArrayList<>();
        for(int i=0; i<parent.length; i++) {
            nodes.add(new Node(s.charAt(i)));
        }

        for(int i=1; i<parent.length; i++) {
            nodes.get(parent[i]).children.add(i);
        }

        dfs(nodes, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] parent = {-1,0,0,1,1,2};
        String s = "abacbe";
        Day9LongestPathWithDifferentAdjacentCharacters obj = new Day9LongestPathWithDifferentAdjacentCharacters();
        System.out.println(obj.longestPath(parent, s));
    }
}
