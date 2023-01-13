package daily.jan23;

public class Day3DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        int deleted = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<strs.length-1; j++) {
                if(strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    deleted++;
                    break;
                }
            }
        }

        return deleted;
    }
}
