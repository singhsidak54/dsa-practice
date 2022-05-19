package algo2;

public class backspaceCompare {
    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        while(i >= 0 || j>=0) {
            int nBackspace = 0;
            while(i >= 0) {
                if(s.charAt(i) == '#') {
                    i--;
                    nBackspace++;
                } else if (nBackspace > 0) {
                    i--;
                    nBackspace--;
                } else {
                    break;
                }
            }
            nBackspace = 0;
            while(j >= 0) {
                if(t.charAt(j) == '#') {
                    j--;
                    nBackspace++;
                } else if (nBackspace > 0) {
                    j--;
                    nBackspace--;
                } else {
                    break;
                }
            }

            if(i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j))
                return false;

            if((i >= 0) != (j >= 0))
                return false;

            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("bxj##t", "bxj###t"));
    }
}
