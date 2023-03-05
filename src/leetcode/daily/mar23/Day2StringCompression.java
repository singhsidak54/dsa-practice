package daily.mar23;


public class Day2StringCompression {
    public int compress(char[] chars) {
        int i = 0, j = 0;
        char curr;

        while (i < chars.length) {
            curr = chars[i];
            int count = 1;
            while (i + 1 < chars.length && chars[i + 1] == curr) {
                count++;
                i++;
            }

            i++;
            chars[j++] = curr;

            if(count > 1) {
                String countStr = String.valueOf(count);
                for(int k=0; k<countStr.length(); k++) {
                    chars[j++] = countStr.charAt(k);
                }
            }
        }

        return j;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        Day2StringCompression obj = new Day2StringCompression();
        System.out.println(obj.compress(chars));
    }
}
