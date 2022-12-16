package daily.dec22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day8LeafSimilarTrees {
    public void leafSimilarHelper(TreeNode node, List<Integer> leaves) {
        if(node == null) return;

        if(node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }

        leafSimilarHelper(node.left, leaves);
        leafSimilarHelper(node.right, leaves);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Leaves = new ArrayList<>();
        List<Integer> root2Leaves = new ArrayList<>();

        leafSimilarHelper(root1, root1Leaves);
        leafSimilarHelper(root2, root2Leaves);

        if(root1Leaves.size() != root2Leaves.size()) return false;

        for(int i=0; i<root1Leaves.size(); i++) {
            if(!root1Leaves.get(i).equals(root2Leaves.get(i))) {
                return false;
            }
        }

        return true;
    }

    public boolean leafSimilarOptimised(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root1);
        s2.push(root2);

        while (!s1.isEmpty() && !s2.isEmpty()) {
            if(dfs(s1) != dfs(s2)) {
                return false;
            }
        }

        return s1.isEmpty() && s2.isEmpty();
    }

    public int dfs(Stack<TreeNode> stack) {
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            while (node != null) {
                if(node.right == null && node.left == null) {
                    return node.val;
                }

                if(node.right != null) {
                    stack.push(node.right);
                }

                node = node.left;
            }
        }
        return -1;
    }
}
