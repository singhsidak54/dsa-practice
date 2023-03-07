package daily.misc;

public class RangeSumQueryMutable {
    class Node {
        int sum;
        int start;
        int end;
        Node left;
        Node right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private Node buildTree(int[] nums, int l, int r) {
        if(l == r) {
            Node node = new Node(l, r);
            node.sum = nums[l];
            return node;
        }

        int mid = l + (r - l)/2;

        Node left = buildTree(nums, l, mid);
        Node right = buildTree(nums, mid + 1, r);

        Node curr = new Node(l, r);
        curr.left = left;
        curr.right = right;
        curr.sum = left.sum + right.sum;

        return curr;
    }

    private void update(Node node, int index, int val) {
        if(node.start == node.end) {
            node.sum = val;
            return;
        }

        int mid = node.start + (node.end - node.start)/2;

        if(index > mid) {
            update(node.right, index, val);
        } else {
            update(node.left, index, val);
        }

        node.sum = node.right.sum + node.left.sum;
    }

    private int sum(Node node, int l, int r) {
        if(node.start == l && node.end == r) {
            return node.sum;
        }

        int mid = node.start + (node.end - node.start)/2;
        if(l > mid) {
            return sum(node.right, l, r);
        } else if(r <= mid) {
            return sum(node.left, l, r);
        } else {
            int left = sum(node.left, l, mid);
            int right = sum(node.right, mid + 1, r);
            return left + right;
        }
    }

    Node root;
    public RangeSumQueryMutable(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    public int sumRange(int left, int right) {
        return sum(root, left, right);
    }

    public static void main(String[] args) {
        RangeSumQueryMutable obj = new RangeSumQueryMutable(new int[] {9, -8});
        obj.update(0, 3);
        System.out.println(obj.sumRange(1, 1));
        System.out.println(obj.sumRange(0, 1));
        obj.update(1, -3);
        System.out.println(obj.sumRange(0, 1));
    }
}
