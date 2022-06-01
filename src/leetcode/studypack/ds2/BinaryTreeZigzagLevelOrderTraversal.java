package ds2;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> secondStack = new Stack<>();
        int level = 0;
        stack.add(root);
        while(!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> currLevelList = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = stack.pop();
                currLevelList.add(node.val);
                if(level % 2 == 0) {
                    if(node.left != null) {
                        secondStack.add(node.left);
                    }

                    if(node.right != null) {
                        secondStack.add(node.right);
                    }
                } else {
                    if(node.right != null) {
                        secondStack.add(node.right);
                    }

                    if(node.left != null) {
                        secondStack.add(node.left);
                    }
                }
            }
            level++;
            result.add(currLevelList);
            stack = secondStack;
            secondStack = new Stack<>();
        }

        return result;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            Deque<Integer> currLevelList = new LinkedList<>();
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(level % 2 == 0) {
                    currLevelList.add(node.val);
                } else {
                    currLevelList.addFirst(node.val);
                }

                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }

            level++;
            result.add(new ArrayList<>(currLevelList));
        }

        return result;
    }

}
