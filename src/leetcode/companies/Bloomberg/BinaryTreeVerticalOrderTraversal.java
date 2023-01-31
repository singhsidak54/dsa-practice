package companies.Bloomberg;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    public class TreeNode {
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

    class Node {
        TreeNode node;
        int col;

        public Node(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, List<Integer>> colNodesMap = new HashMap<>();
        int minCol = 0, maxCol = 0;
        queue.add(new Node(root, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if(!colNodesMap.containsKey(curr.col)) {
                colNodesMap.put(curr.col, new ArrayList<>());
            }

            minCol = Math.min(minCol, curr.col);
            maxCol = Math.max(maxCol, curr.col);
            colNodesMap.get(curr.col).add(curr.node.val);

            if(curr.node.left != null) {
                queue.add(new Node(curr.node.left, curr.col - 1));
            }

            if(curr.node.right != null) {
                queue.add(new Node(curr.node.right, curr.col + 1));
            }
        }


        List<List<Integer>> result = new ArrayList<>();
        for(int i=minCol; i<=maxCol; i++) {
            result.add(colNodesMap.get(i));
        }

        return result;
    }
}
