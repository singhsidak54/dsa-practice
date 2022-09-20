package lc75l2;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public void rightSideViewHelper(TreeNode node, int index, List<Integer> res) {
        if(node == null) return;

        if(res.size() == index) {
            res.add(node.val);
        }
        rightSideViewHelper(node.right, index + 1, res);
        rightSideViewHelper(node.left, index + 1, res);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightSideViewHelper(root, 0, res);
        return res;
    }
}
