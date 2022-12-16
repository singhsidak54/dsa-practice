package companies.Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {
    class Node {
        int u;
        int l;
        int r;
        public Node(int l, int r, int u) {
            this.l = l;
            this.r = r;
            this.u = u;
        }
    }

    class QueueNode {
        int position;
        StringBuilder path;
        public QueueNode(int position, StringBuilder path) {
            this.position = position;
            this.path = path;
        }
    }

    HashMap<Integer, Node> map;
    public void buildGraph(TreeNode node, int parent) {
        int left = node.left == null ? -1 : node.left.val;
        int right = node.right == null ? -1 : node.right.val;

        Node curr = new Node(left, right, parent);
        map.put(node.val, curr);

        if(left != -1) {
            buildGraph(node.left, node.val);
        }

        if(right != -1) {
            buildGraph(node.right, node.val);
        }
    }

    // takes too much time. TLE
    public String getDirectionsBFS(TreeNode root, int startValue, int destValue) {
        map = new HashMap<>();
        buildGraph(root, -1);
        HashSet<Integer> seen = new HashSet<>();
        Queue<QueueNode> queue = new LinkedList<>();

        queue.add(new QueueNode(startValue, new StringBuilder()));
        seen.add(startValue);

        while (!queue.isEmpty()) {
            QueueNode temp = queue.poll();

            Node curr = map.get(temp.position);

            if(curr.l != -1 && !seen.contains(curr.l)) {
                StringBuilder leftPath = new StringBuilder(temp.path);
                leftPath.append('L');
                if(curr.l == destValue) {
                    return leftPath.toString();
                }
                queue.add(new QueueNode(curr.l, leftPath));
                seen.add(curr.l);
            }

            if(curr.r != -1 && !seen.contains(curr.r)) {
                StringBuilder rightPath = new StringBuilder(temp.path);
                rightPath.append('R');
                if(curr.r == destValue) {
                    return rightPath.toString();
                }
                queue.add(new QueueNode(curr.r, rightPath));
                seen.add(curr.r);
            }

            if(curr.u != -1 && !seen.contains(curr.u)) {
                StringBuilder upPath = new StringBuilder(temp.path);
                upPath.append('U');
                if(curr.u == destValue) {
                    return upPath.toString();
                }
                queue.add(new QueueNode(curr.u, upPath));
                seen.add(curr.u);
            }
        }

        return "";
    }

    public TreeNode LCA(TreeNode node, int a, int b) {
        if(node == null) return null;

        if(node.val == a || node.val == b) return node;

        TreeNode left = LCA(node.left, a, b);
        TreeNode right = LCA(node.right, a, b);

        if(left != null && right != null) {
            return node;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    public boolean traverse(TreeNode node, int destination, StringBuilder path) {
        if(node == null) return false;

        if(node.val == destination) return true;

        // traverse left and check
        path.append('L');
        if(!traverse(node.left, destination, path)) {
            path.deleteCharAt(path.length() - 1);
        } else {
            return true;
        }

        // traverse right and check
        path.append('R');
        if(!traverse(node.right, destination, path)) {
            path.deleteCharAt(path.length() - 1);
        } else {
            return true;
        }

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = LCA(root, startValue, destValue);

        StringBuilder lcaToStart = new StringBuilder();
        StringBuilder lcaToDest = new StringBuilder();

        traverse(lca, startValue, lcaToStart);
        traverse(lca, destValue, lcaToDest);

        return "U".repeat(lcaToStart.length()) + lcaToDest;
    }

    public boolean findPath(TreeNode node, int destination, StringBuilder path) {
        if(node == null) return false;

        if(node.val == destination) return true;

        if(findPath(node.left, destination, path)) {
            path.append('L');
            return true;
        } else if (findPath(node.right, destination, path)) {
            path.append('R');
            return true;
        }

        return false;
    }

    public String getDirectionsOptimised(TreeNode root, int startValue, int destValue) {
        StringBuilder startToRoot = new StringBuilder();
        StringBuilder destinationToRoot = new StringBuilder();

        findPath(root, startValue, startToRoot);
        findPath(root, destValue, destinationToRoot);

        int i = 0, maxI = Math.min(startToRoot.length(), destinationToRoot.length());
        while (i < maxI && startToRoot.charAt(startToRoot.length() - 1 - i) == destinationToRoot.charAt(destinationToRoot.length() - 1 - i)) {
            i++;
        }

        return "U".repeat(startToRoot.length() - i) + destinationToRoot.reverse().substring(i);
    }
}
