package daily.apr24;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SmallestStringStartingFromLeaf {

    // incorrect approach. fails for bae vs be
    public static List<Integer> helper(TreeNode node) {
        if(node == null) {
            return null;
        }

        if(node.left == null && node.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            return list;
        }

        List<Integer> left = helper(node.left);
        List<Integer> right = helper(node.right);

        if(left == null) {
            right.add(node.val);
            return right;
        } else if(right == null) {
            left.add(node.val);
            return left;
        } else {
            int i = 0, j = 0;
            List<Integer> smaller = null;
            while (i < left.size() && j < right.size()) {
                int l = left.get(i++), r = right.get(j++);
                if(l == r) continue;
                if(l < r) {
                    smaller = left;
                } else {
                    smaller = right;
                }
                break;
            }

            if(smaller == null) {
                if(i > 0) smaller = right;
                else smaller = left;
            }

            smaller.add(node.val);
            return smaller;
        }
    }
    public static String smallestFromLeafIncorrect(TreeNode root) {
        List<Integer> ans = helper(root);
        StringBuilder res = new StringBuilder();
        for(int ch : ans) {
            res.append((char) ('a' + ch));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(0, new TreeNode(1), null);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;

        String ans = smallestFromLeafIncorrect(root);
        System.out.println(ans);
    }
}
