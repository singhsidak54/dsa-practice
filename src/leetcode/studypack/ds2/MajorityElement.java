package ds2;

import java.util.HashMap;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int majorityCount = nums.length/2;
        for(int n : map.keySet()) {
            if(map.get(n) > majorityCount)
                return n;
        }
        return -1;
    }
    //Boyer-Moore Voting Algorithm
    public static int majorityElementBMVA (int[] nums){
        int candidate = -1;
        int count = 0;
        for(int n: nums) {
            if(count == 0)
                candidate = n;

            count += (n == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,3,1};
        System.out.println(majorityElementBMVA(a));
    }
}
