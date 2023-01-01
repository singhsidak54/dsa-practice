package misc;

import java.util.ArrayList;

// Problem Link - https://www.scaler.com/academy/mentee-dashboard/class/7326/assignment/problems/9961?navref=cl_tt_lst_nm
public class PrefixMatching {
    public static boolean isPrefix(String A, String B) {
        if(A.length() < B.length()) return false;

        for(int i=0; i<B.length(); i++) {
            if(A.charAt(i) != B.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static int binarySearchLastIndex(ArrayList<String> A, String B, int l) {
        int r = A.size() - 1, m;
        while (l < r) {
            m = l + (r - l)/2 + 1;
            if(isPrefix(A.get(m), B)) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        if(l == A.size() || !isPrefix(A.get(l), B)) return -1;
        return l;
    }

    public static int binarySearchFirstIndex(ArrayList<String> A, String B) {
        int l = 0, r = A.size(), m;
        while (l < r) {
            m = l + (r - l)/2;
            if(isPrefix(A.get(m), B)) {
                r = m;
            } else if(A.get(m).compareTo(B) > 0) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        if(l == A.size()) return -1;
        return l;
    }

    public static ArrayList<Integer> solve(ArrayList<String> A, String B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int firstIndex = binarySearchFirstIndex(A, B);
        if(firstIndex == -1) {
            ans.add(-1);
            ans.add(-1);
            return ans;
        }

        int lastIndex = binarySearchLastIndex(A, B, firstIndex);

        ans.add(firstIndex);
        ans.add(lastIndex);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>();
        A.add("aaa");
        A.add("aaa");
        A.add("aaab");
        A.add("b");
        A.add("bab");
        A.add("bbaa");
        A.add("bbaaa");
        A.add("bbbb");
        A.add("bbbbb");

        System.out.println(solve(A, "aaa"));
    }
}
