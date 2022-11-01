package patterns.intuit;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LowestCommonAncestorOfABinaryTree {
    TreeNode ans = null;
    public boolean lCAHelper(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) return false;

        int left = lCAHelper(node.left, p, q) ? 1 : 0;
        int right = lCAHelper(node.right, p, q)? 1 : 0;
        int mid = (node.val == p.val || node.val == q.val) ? 1 : 0;

        if(left + right + mid >= 2) {
            this.ans = node;
        }

        return left + mid + right > 0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lCAHelper(root, p, q);
        return this.ans;
    }

    class Node {
        TreeNode curr;
        TreeNode parent;
        public Node(TreeNode curr, TreeNode parent) {
            this.curr = curr;
            this.parent = parent;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode curr = queue.poll();

            if(curr.left != null) {
                queue.add(curr.left);
                parentMap.put(curr.left, curr);
            }

            if(curr.right != null) {
                queue.add(curr.right);
                parentMap.put(curr.right, curr);
            }
        }

        Set<TreeNode> pAncestors = new HashSet<>();
        TreeNode curr = p;
        while (curr != root) {
            pAncestors.add(curr);
            curr = parentMap.get(curr);
        }

        curr = q;
        while (curr != root) {
            if(pAncestors.contains(curr)) {
                return curr;
            }
            curr = parentMap.get(curr);
        }

        return root;
    }
}
