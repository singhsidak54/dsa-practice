package daily.oct24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day26HeightOfBinaryTreeAfterSubtreeRemovalQueries {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    Map<Integer, Integer> heights;
    Map<Integer, Integer> prefixHeightWithoutNode;

    public int height(TreeNode node) {
        if(node == null) return 0;

        heights.put(node.val, 1 + Math.max(height(node.left), height(node.right)));
        return heights.get(node.val);
    }

    public void buildPrefixArray(TreeNode node, int level, int maxFromOtherSide) {
        if(node == null) return;

        int idx = node.val;
        prefixHeightWithoutNode.put(idx, Math.max(level - 1, maxFromOtherSide));

        int leftHeight = level + (node.left != null ? heights.get(node.left.val) : 0);
        int rightHeight = level + (node.right != null ? heights.get(node.right.val) : 0);
        buildPrefixArray(node.left, level + 1, Math.max(rightHeight, maxFromOtherSide));
        buildPrefixArray(node.right, level + 1, Math.max(leftHeight, maxFromOtherSide));
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        prefixHeightWithoutNode = new HashMap<>();
        heights = new HashMap<>();

        height(root);
        buildPrefixArray(root, 0, 0);

        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            ans[i] = prefixHeightWithoutNode.get(queries[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode left2 = new TreeNode(2);
        TreeNode left1 = new TreeNode(3, left2, null);

        TreeNode right3 = new TreeNode(7);
        TreeNode right2R = new TreeNode(5, null, right3);
        TreeNode right2L = new TreeNode(6);
        TreeNode right1 = new TreeNode(4, right2L, right2R);

        TreeNode root = new TreeNode(1, left1, right1);

        Day26HeightOfBinaryTreeAfterSubtreeRemovalQueries obj = new Day26HeightOfBinaryTreeAfterSubtreeRemovalQueries();
        int[] qs = {4, 7, 5};
        System.out.println(Arrays.toString(obj.treeQueries(root, qs)));

    }
}
