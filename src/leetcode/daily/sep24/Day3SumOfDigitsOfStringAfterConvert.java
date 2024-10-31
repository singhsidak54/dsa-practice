package daily.sep24;

public class Day3SumOfDigitsOfStringAfterConvert {
    public int getLucky(String s, int k) {
        StringBuilder str = new StringBuilder();
        for(char c : s.toCharArray()) {
            str.append((c - 'a') + 1);
        }

        s = str.toString();
        while (k > 0) {
            int total = 0;
            for(int i=0; i<s.length(); i++) {
                total += (s.charAt(i) - '0');
            }
            s = String.valueOf(total);
            k--;
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        Day3SumOfDigitsOfStringAfterConvert obj = new Day3SumOfDigitsOfStringAfterConvert();
        System.out.println(obj.getLucky("zbax", 2));
    }
}
