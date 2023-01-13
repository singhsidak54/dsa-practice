package Scaler.Primer.Strings;

public class VowelIt {
    public String solve(String A) {
        StringBuilder sol = new StringBuilder();
        for(char c : A.toCharArray()) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                sol.append(c);
            }
        }

        return sol.toString();
    }
}
