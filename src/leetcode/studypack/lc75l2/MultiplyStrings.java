package lc75l2;

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        StringBuilder first = new StringBuilder(num1);
        StringBuilder second = new StringBuilder(num2);
        first.reverse();
        second.reverse();

        int n = first.length() + second.length();
        for(int i=0; i<n; i++) {
            result.append("0");
        }

        for(int i=0; i<first.length(); i++) {
            int digit1 = first.charAt(i) - '0';
            for(int j=0; j<second.length(); j++) {
                int digit2 = second.charAt(j) - '0';

                int position = i + j, carry = result.charAt(position) - '0', num = digit1 * digit2 + carry;
                result.setCharAt(position, (char) (num % 10 + '0'));
                int carryNext = (result.charAt(position + 1) - '0') + num/10;
                result.setCharAt(position + 1, (char) (carryNext + '0'));
            }
        }

        while (result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }
}
