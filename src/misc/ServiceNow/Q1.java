package misc.ServiceNow;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public long countSubarrays(List<Integer> numbers, int k) {
        long ans = 0;
        int curr = 1;

        int start = 0, end = 0;
        while (end < numbers.size()) {
            curr *= numbers.get(end);
            while (start <= end && curr > k) {
                curr = curr/numbers.get(start);
                start++;
            }

            if(curr <= k) {
                ans += (end - start + 1);
            }
            
            end++;
        }

        return ans;
    }


    public static void main(String[] args) {
        List<Integer> n = new ArrayList<>();
        n.add(2);
        n.add(3);
        n.add(4);
        Q1 obj = new Q1();
        System.out.println(obj.countSubarrays(n, 6));
    }
}
