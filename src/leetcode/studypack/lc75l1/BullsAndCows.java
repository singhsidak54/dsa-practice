package lc75l1;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] secretDigits = new int[10];
        int bulls = 0;
        int cows = 0;

        for(int i=0; i<secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                secretDigits[secret.charAt(i) - '0']++;
            }
        }

        for(int i=0; i<guess.length(); i++) {
            if(secret.charAt(i) != guess.charAt(i) && secretDigits[guess.charAt(i) - '0'] > 0) {
                cows++;
                secretDigits[guess.charAt(i) - '0']--;
            }
        }

        return bulls + "A" + cows + "B";
    }

    public String getHint2(String secret, String guess) {
        int[] secretDigits = new int[10];
        int bulls = 0;
        int cows = 0;

        for(int i=0; i<secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if(secretDigits[guess.charAt(i) - '0'] > 0) cows++;

                if(secretDigits[secret.charAt(i) - '0'] < 0) cows++;

                secretDigits[guess.charAt(i) - '0']--;
                secretDigits[secret.charAt(i) - '0']++;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
