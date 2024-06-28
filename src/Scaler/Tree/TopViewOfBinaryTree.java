package Scaler.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfBinaryTree {

    class Pair {
        int level;
        TreeNode node;

        public Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public ArrayList<Integer> solve(TreeNode A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, A));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            if(!map.containsKey(curr.level)) {
                map.put(curr.level, curr.node.val);
            }

            if(curr.node.left != null) {
                queue.add(new Pair(curr.level - 1, curr.node.left));
            }

            if(curr.node.right != null) {
                queue.add(new Pair(curr.level + 1, curr.node.right));
            }
        }

        return new ArrayList<>(map.values());
    }
}
