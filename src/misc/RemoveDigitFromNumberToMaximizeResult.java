package misc;

public class RemoveDigitFromNumberToMaximizeResult {
    public String removeDigit(String number, char digit) {
        for(int i=0; i<number.length()-1; i++) {
            if(number.charAt(i) == digit && digit < number.charAt(i+1)) {
                return number.substring(0, i) + number.substring(i+1);
            }
        }

        int digitLastIndex = number.lastIndexOf(digit);
        return number.substring( 0, digitLastIndex) + number.substring(digitLastIndex + 1);
    }
}
