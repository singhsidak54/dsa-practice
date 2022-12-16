package daily.dec22;

public class Day10MaximumProductOfSplittedBinaryTree {

    int totalTreeSum = 0;
    long bestProduct = 0;
    int mod = 1000000007;
    public int sum(TreeNode node) {
        if(node == null) return 0;

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        return leftSum + rightSum + node.val;
    }

    public int maxProductHelper(TreeNode node) {
        if(node == null) return 0;

        int leftSum = maxProductHelper(node.left);
        int rightSum = maxProductHelper(node.right);
        int totalSum = leftSum + rightSum + node.val;
        long currentProduct = (long) totalSum * (totalTreeSum - totalSum);

        this.bestProduct = Math.max(this.bestProduct, currentProduct);

        return totalSum;
    }

    public int maxProduct(TreeNode root) {
        totalTreeSum = sum(root);
        maxProductHelper(root);
        return (int) (this.bestProduct % mod);
    }
}
