package Scaler.Stack;

public class DoubleCharacterTrouble {
    public static String solve(String A) {
        StringBuilder str = new StringBuilder();
        for(char c : A.toCharArray()) {
            if(str.length() != 0 && str.charAt(str.length() - 1) == c) {
                str.deleteCharAt(str.length() - 1);
            } else {
                str.append(c);
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(solve("abccbc"));
    }
}
