package Scaler.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class LevelOrder {
    class Pair {
        int level;
        TreeNode node;
        public Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> curr = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                curr.add(node.val);

                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }

            ans.add(curr);
        }

        return ans;
    }
}
