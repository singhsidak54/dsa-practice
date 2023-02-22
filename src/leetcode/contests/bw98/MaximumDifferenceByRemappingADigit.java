package contests.bw98;

public class MaximumDifferenceByRemappingADigit {
    public static int minMaxDifference(int num) {
        // find minimum
        String n = String.valueOf(num);
        char d = n.charAt(0);
        int i = 0;
        while (i < n.length() && n.charAt(i) == d) {
            i++;
        }

        int minimum;
        if(i == n.length()) {
            minimum = 0;
        } else {
            StringBuilder minStr = new StringBuilder(n.substring(i));
            for(int j=0; j<minStr.length(); j++) {
                if(minStr.charAt(j) == d) {
                    minStr.setCharAt(j, '0');
                }
            }

            minimum = Integer.parseInt(minStr.toString());
        }

        // find maximum
        i = 0;
        StringBuilder maxStr = new StringBuilder(String.valueOf(num));
        while (i < maxStr.length() && maxStr.charAt(i) == '9') {
            i++;
        }

        if(i < maxStr.length()) {
            d = maxStr.charAt(i);
            while (i < maxStr.length()) {
                if(maxStr.charAt(i) == d) {
                    maxStr.setCharAt(i, '9');
                }
                i++;
            }
        }

        int maximum = Integer.parseInt(maxStr.toString());

        return maximum - minimum;
    }

    public static void main(String[] args) {
        System.out.println(minMaxDifference(22222));
    }
}
