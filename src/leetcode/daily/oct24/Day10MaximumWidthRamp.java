package daily.oct24;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Day10MaximumWidthRamp {
    class Node {
        int originalIdx;
        int val;
        public Node(int originalIdx, int val) {
            this.originalIdx = originalIdx;
            this.val = val;
        }
    }

    public int maxWidthRamp(int[] nums) {
        Node[] nodes = new Node[nums.length];
        for(int i=0; i<nums.length; i++) {
            nodes[i] = new Node(i, nums[i]);
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.val == o2.val) return Integer.compare(o1.originalIdx, o2.originalIdx);
                return Integer.compare(o1.val, o2.val);
            }
        });

        int minOriginalIdx = Integer.MAX_VALUE, ans = 0;
        for (Node node : nodes) {
            if (node.originalIdx > minOriginalIdx) {
                ans = Math.max(ans, node.originalIdx - minOriginalIdx);
            } else {
                minOriginalIdx = node.originalIdx;
            }
        }

        return ans;
    }

    public int maxWidthRampOptimised(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        // build stack
        for(int i=0; i<nums.length; i++) {
            if(stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        if (stack.isEmpty()) return 0;
        int maxWidth = 0;
        for(int i=nums.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                maxWidth = Math.max(maxWidth, i - stack.pop());
            }

            if(stack.isEmpty()) break;
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        int[] nums = {9,8,1,0,1,9,4,0,4,1};
        Day10MaximumWidthRamp obj = new Day10MaximumWidthRamp();
        System.out.println(obj.maxWidthRamp(nums));
    }
}
