package ds2;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    String nullNode = "NN";
    String splitter = ",";
    Queue<TreeNode> queue = new LinkedList<>();
    public String serialize(TreeNode root) {
        queue.clear();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {
                sb.append(nullNode);
            } else {
                sb.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            sb.append(splitter);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        queue.clear();
        String[] serializedTree = data.split(splitter);
        int index = 0;
        if(serializedTree[index].equals(nullNode)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(serializedTree[index]));
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;
            if(!serializedTree[leftIndex].equals(nullNode)) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(serializedTree[leftIndex]));
                node.left = leftNode;
                queue.add(leftNode);
            }

            if(!serializedTree[rightIndex].equals(nullNode)) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(serializedTree[rightIndex]));
                node.right = rightNode;
                queue.add(rightNode);
            }
            index++;
        }

        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree obj = new SerializeAndDeserializeBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serializedTree = obj.serialize(root);
        Integer.compare(1,2);
        root = obj.deserialize(serializedTree);
        System.out.println(root);
    }
}
