package ds2;

public class AddStrings {
    public static String addStrings(String num1, String num2) {
        if(num1.length() > num2.length())
            return addStrings(num2, num1);
        int carry = 0;
        StringBuilder result = new StringBuilder();
        int n1Len = num1.length()-1;
        int n2Len = num2.length()-1;
        int n = Math.min(n1Len, n2Len);
        int m = Math.max(n1Len, n2Len);
        while (n >= 0 && m >= 0) {
            int n1 = Integer.parseInt(String.valueOf(num1.charAt(n)));
            int n2 = Integer.parseInt(String.valueOf(num2.charAt(m)));
            int res = n1 + n2;
            if(carry > 0) {
                res += carry;
                carry = 0;
            }
            if(res/10 > 0) {
                carry = res/10;
                res = res % 10;
            }

            result.append(res);
            n--;
            m--;
        }

        while(n >= 0) {
            int n1 = Integer.parseInt(String.valueOf(num1.charAt(n)));
            if(carry > 0) {
                n1 += carry;
                if(n1/10 > 0) {
                    carry = n1/10;
                    n1 = n1 % 10;
                } else {
                    carry = 0;
                }
            }
            result.append(n1);
            n--;
        }

        while(m >= 0) {
            int n2 = Integer.parseInt(String.valueOf(num2.charAt(m)));
            if(carry > 0) {
                n2 += carry;
                if(n2/10 > 0) {
                    carry = n2/10;
                    n2 = n2 % 10;
                } else {
                    carry = 0;
                }
            }
            result.append(n2);
            m--;
        }

        if(carry > 0)
            result.append(carry);
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("0", "0"));
    }
}
