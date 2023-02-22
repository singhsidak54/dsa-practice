package daily.feb23;

public class Day14AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int n1 = a.charAt(i--) - '0';
            int n2 = b.charAt(j--) - '0';

            int toAdd = n1 + n2 + carry;
            result.append(toAdd % 2);
            carry = toAdd / 2;
        }

        while (i >= 0) {
            int n1 = a.charAt(i--) - '0';
            int toAdd = n1 + carry;
            result.append(toAdd % 2);
            carry = toAdd / 2;
        }

        while (j >= 0) {
            int n2 = b.charAt(j--) - '0';
            int toAdd = n2 + carry;
            result.append(toAdd % 2);
            carry = toAdd / 2;
        }

        if(carry > 0) {
            result.append(1);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Day14AddBinary obj = new Day14AddBinary();
        System.out.println(obj.addBinary("11", "1"));
    }
}
