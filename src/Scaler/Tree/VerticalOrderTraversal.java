package Scaler.Tree;

import java.util.*;

public class VerticalOrderTraversal {

    class Pair {
        int level;
        TreeNode node;
        public Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(A == null) return ans;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int minLevel = 0, maxLevel = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, A));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            ArrayList<Integer> levelList = map.getOrDefault(curr.level, new ArrayList<>());
            levelList.add(curr.node.val);

            if(curr.node.left != null) {
                queue.add(new Pair(curr.level - 1, curr.node.left));
                minLevel = Math.min(minLevel, curr.level - 1);
            }

            if(curr.node.right != null) {
                queue.add(new Pair(curr.level + 1, curr.node.right));
                maxLevel = Math.max(maxLevel, curr.level + 1);
            }

            map.put(curr.level, levelList);
        }

        for(int i=minLevel; i<=maxLevel; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }
}
