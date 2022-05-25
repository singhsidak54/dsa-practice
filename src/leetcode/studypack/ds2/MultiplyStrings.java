package ds2;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        StringBuilder result = new StringBuilder();
        StringBuilder firstNum = new StringBuilder(num1);
        StringBuilder secondNum = new StringBuilder(num2);
        firstNum.reverse();
        secondNum.reverse();

        int N = firstNum.length() + secondNum.length();
        for(int i=0; i<N; i++) {
            result.append("0");
        }

        for(int i=0; i<secondNum.length(); i++) {
            int digit2 = secondNum.charAt(i) - '0';
            for(int j=0; j<firstNum.length(); j++) {
                int digit1 = firstNum.charAt(j) - '0';

                int position = i + j;
                int carry = result.charAt(position) - '0';
                int currResult = digit1 * digit2 + carry;

                result.setCharAt(position, (char) (currResult % 10 + '0'));
                int carryNext = (result.charAt(position + 1) - '0') + currResult/10;
                result.setCharAt(position+1, (char) (carryNext + '0'));
            }
        }

        while (result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }

        return result.reverse().toString();
    }
}
