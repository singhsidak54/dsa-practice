package Scaler.Tree;

import java.util.ArrayList;

public class RightViewOfBinaryTree {
    ArrayList<Integer> list;

    public void dfs(TreeNode node, int depth) {
        if(node == null) return;

        if(list.size() == depth)  {
            list.add(node.val);
        } else {
            list.set(depth, node.val);
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    public ArrayList<Integer> solve(TreeNode A) {
        list = new ArrayList<>();
        dfs(A, 0);
        return list;
    }
}
