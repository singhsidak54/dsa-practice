package daily.aug24;

import java.util.ArrayList;
import java.util.Arrays;

public class Day24FindTheClosestPalindrome {
    public long getCandidate(long leftHalf, boolean isEven) {
        long res = leftHalf;
        if(!isEven) leftHalf /= 10;
        while (leftHalf > 0) {
            res = res * 10 + leftHalf % 10;
            leftHalf /= 10;
        }

        return res;
    }

    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);

        if(num <= 10) return "" + (num - 1);
        long leftHalf = Long.parseLong(n.substring(0, (len + 1)/2));
        boolean isEven = len % 2 == 0;

        //Get Candidates
        ArrayList<Long> candidates = new ArrayList<>();
        candidates.add(getCandidate(leftHalf, isEven));
        candidates.add(getCandidate(leftHalf - 1, isEven));
        candidates.add(getCandidate(leftHalf + 1, isEven));
        candidates.add(getCandidate((long) Math.pow(10, len - 1) - 1, isEven));
        candidates.add(getCandidate((long) Math.pow(10, len) + 1, isEven));

        Long ans = Long.MAX_VALUE, minDiff = Long.MAX_VALUE;
        for(Long candidate : candidates) {
            long diff = Math.abs(num - candidate);
            if(diff < minDiff || (diff == minDiff && candidate < ans)) {
                ans = candidate;
                minDiff = diff;
            }
        }

        return ans.toString();
    }

    public long toPalindrome(long num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();
        int left = (len-1)/2, right = len/2;
        char[] numArray = numStr.toCharArray();
        while (left >= 0) {
            numArray[right] = numArray[left];
            left--;
            right++;
        }

        return Long.parseLong(String.valueOf(numArray));
    }

    public long prevSmaller(long num) {
        long left = 0, right = (long) 1e18, ans = 0L;
        while(left <= right) {
            long mid = (right - left) / 2 + left;
            long palindrome = toPalindrome(mid);
            if(palindrome < num) {
                ans = palindrome;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public long nextGreater(long num) {
        long left = 0, right = (long) 1e18, ans = 0L;
        while(left <= right) {
            long mid = (right - left) / 2 + left;
            long palindrome = toPalindrome(mid);
            if(palindrome > num) {
                ans = palindrome;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public String nearestPalindromicBinarySearch(String n) {
        long nl = Long.parseLong(n);
        long choiceA = prevSmaller(nl), choiceB = nextGreater(nl);
        if(Math.abs(nl - choiceA) <= Math.abs(choiceB - nl)) {
            return String.valueOf(choiceA);
        }

        return String.valueOf(choiceB);
    }

    public static void main(String[] args) {
        Day24FindTheClosestPalindrome obj = new Day24FindTheClosestPalindrome();
        System.out.println(obj.nearestPalindromicBinarySearch("88"));
    }
}
