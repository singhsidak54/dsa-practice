package companies.Intuit;

import java.util.LinkedList;
import java.util.Queue;


// Definition for a binary tree node.
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


class QueueNode {
    TreeNode node;
    int parent;
    int grandParent;
    public QueueNode(TreeNode node, int parent, int grandParent) {
        this.node = node;
        this.parent = parent;
        this.grandParent = grandParent;
    }
}

public class SumOfNodesWithEvenValuedGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        int ans = 0;
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[] {root, null, null});

        while (!queue.isEmpty()) {
            TreeNode[] curr = queue.poll();
            if(curr[2] != null && curr[2].val % 2 == 0) {
                ans += curr[0].val;
            }

            if(curr[0].left != null) {
                queue.add(new TreeNode[] {curr[0].left, curr[0], curr[1]});
            }

            if(curr[0].right != null) {
                queue.add(new TreeNode[] {curr[0].right, curr[0], curr[1]});
            }
        }

        return ans;
    }

    public int sumEvenGrandparentOptimised(TreeNode root) {
        int ans = 0;
        Queue<QueueNode> queue = new LinkedList<>();
        queue.add(new QueueNode(root, 1, 1));

        while (!queue.isEmpty()) {
            QueueNode curr = queue.poll();
            if(curr.grandParent % 2 == 0) {
                ans += curr.node.val;
            }

            if(curr.node.left != null) {
                queue.add(new QueueNode(curr.node.left, curr.node.val, curr.parent));
            }

            if(curr.node.right != null) {
                queue.add(new QueueNode(curr.node.right, curr.node.val, curr.parent));
            }
        }

        return ans;
    }
}
