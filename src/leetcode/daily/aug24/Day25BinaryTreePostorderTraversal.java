package daily.aug24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Day25BinaryTreePostorderTraversal {
    static class TreeNode {
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

    public void dfs(TreeNode node, List<Integer> res) {
        if(node == null) return;

        dfs(node.left, res);
        dfs(node.right, res);
        res.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
             TreeNode curr = stack.pop();
             res.addFirst(curr.val);

             // push left node if not null
            if(curr.left != null) stack.push(curr.left);

            // push right node if not null
            if(curr.right != null) stack.push(curr.right);
        }

        return res;
    }

/* Learning Morris Traversal */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            // if no left subtree
            if(curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                // find the predecessor of the current node in the left subtree (the rightmost node)
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                // if the rightmost node's right node already points to the current node then the left subtree is already visited
                // we should just visit the current node and move to the right subtree
                if(pre.right == curr) {
                    // remove the link to current from predecessor so that our changes to original tree aren't persisted
                    pre.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                } else {
                    // set the rightmost node's right to current and start processing the left subtree
                    pre.right = curr;
                    curr = curr.left;
                }
            }
        }

        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {

            // if no left subtree
            if(curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                // find the predecessor of the current node's right subtree in it's left subtree (the rightmost node)
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                // if the rightmost node already points to the current node then we know that left subtree is visited
                // we should just move to the right subtree of the current node
                if(pre.right == curr) {
                    // remove the link to current from predecessor so that our changes to original tree aren't persisted
                    pre.right = null;
                    curr = curr.right;
                } else {
                    res.add(curr.val);
                    pre.right = curr;
                    curr = curr.left;
                }
            }
        }

        return res;
    }

    public List<Integer> postorderTraversalMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        // If the root is null, return an empty list
        if (root == null) {
            return res;
        }

        // Create a dummy node to simplify edge cases
        TreeNode dummyNode = new TreeNode(-1);
        dummyNode.left = root;
        TreeNode curr = dummyNode;

        // Traverse the tree
        while (curr != null) {
            // if no left subtree
            if(curr.left == null) {
                curr = curr.right;
            } else {
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }

                // if predecessor.right is null, it means left subtree isn't yet visited.
                if(predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    // the left part of the left subtree is added. we need to add the right part first and then the node itself
                    // to add right parts from right to left, we first reverse them
                    reverseSubtreeLinks(curr.left, predecessor);

                    while (predecessor != curr.left) {
                        res.add(predecessor.val);
                        predecessor = predecessor.right;
                    }

                    // add the root of the left subtree
                    res.add(predecessor.val);
                    // move to the right subtree of current
                    predecessor.right = null;
                    curr = curr.right;
                }
            }
        }

        return res;
    }

    private void reverseSubtreeLinks(TreeNode startNode, TreeNode endNode) {
        if(startNode == endNode) return;

        TreeNode prev = null, current = startNode, next;
        while (current != endNode) {
            next = current.right;
            current.right = prev;
            prev = current;
            current = next;
        }

        current.right = prev;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5, new TreeNode(2), new TreeNode(3));
        root.right = new TreeNode(4, new TreeNode(6), new TreeNode(7));
        Day25BinaryTreePostorderTraversal obj = new Day25BinaryTreePostorderTraversal();
        List<Integer> traversal = obj.postorderTraversalMorris(root);
        System.out.println(traversal);
    }
}
