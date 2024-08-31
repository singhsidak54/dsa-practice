package daily.aug24;

public class Day23FractionAdditionAndSubtraction {
    public int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }

    public String fractionAddition(String expression) {
        int num = 0, den = 1, i = 0;
        boolean isNegative = false;

        while (i < expression.length()) {
            // check if the current fraction is to be subtracted
            if(expression.charAt(i) == '-') {
                isNegative = true;
                i++;
            } else if (expression.charAt(i) == '+') {
                i++;
            }

            int currentNum = 0, currentDen = 0;

            // get numerator
            while (expression.charAt(i) != '/') {
                currentNum = currentNum * 10 + (expression.charAt(i) - '0');
                i++;
            }

            i++;

            if(isNegative) currentNum *= -1;
            isNegative = false;

            // get denominator
            while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                currentDen = currentDen * 10 + (expression.charAt(i) - '0');
                i++;
            }

            if(currentDen == 0) currentDen = 1;

            num = num * currentDen + currentNum * den;
            den = den * currentDen;
        }


        int gcd = Math.abs(gcd(num, den));
        num /= gcd;
        den /= gcd;

        return num + "/" + den;
    }

    public static void main(String[] args) {
        Day23FractionAdditionAndSubtraction obj = new Day23FractionAdditionAndSubtraction();
        System.out.println(obj.fractionAddition("1/3-1/2"));
    }
}
