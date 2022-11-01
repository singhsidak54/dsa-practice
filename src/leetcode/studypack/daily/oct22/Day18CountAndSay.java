package daily.oct22;

public class Day18CountAndSay {
    public static String countAndSay(int n) {
        int i = 1;
        StringBuilder curr = new StringBuilder("1");

        while (i != n) {
            StringBuilder temp = new StringBuilder();
            int count = 1, j = 1;
            while (j < curr.length()) {
                if(curr.charAt(j) == curr.charAt(j-1)) {
                    count++;
                } else {
                    temp.append(count);
                    temp.append(curr.charAt(j-1));
                    count = 1;
                }
                j++;
            }
            temp.append(count);
            temp.append(curr.charAt(j - 1));
            curr = temp;
            i++;
        }

        return curr.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
