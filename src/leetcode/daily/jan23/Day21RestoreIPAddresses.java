package daily.jan23;

import java.util.ArrayList;
import java.util.List;

public class Day21RestoreIPAddresses {
    static List<String> result;

    public static void dfs(String s, int index, StringBuilder total, int dotsAdded) {
        if(dotsAdded > 4) return;
        if(index == s.length()) {
            if(dotsAdded == 4) {
                StringBuilder toAdd = new StringBuilder(total);
                toAdd.deleteCharAt(toAdd.length() - 1);
                result.add(toAdd.toString());
            }
            return;
        }

        int j = index;
        StringBuilder curr = new StringBuilder();
        while (curr.length() < 3 && j < s.length()) {
            curr.append(s.charAt(j));
            if(Integer.parseInt(curr.toString()) > 255) break;
            total.append(curr);
            total.append('.');
            dfs(s, j + 1, total, dotsAdded + 1);
            total.delete(total.length() - curr.length() - 1, total.length());

            if(s.charAt(j) == '0' && curr.length() == 1) {
                break;
            }
            j++;
        }
    }
    public static List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        dfs(s, 0, new StringBuilder(), 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
