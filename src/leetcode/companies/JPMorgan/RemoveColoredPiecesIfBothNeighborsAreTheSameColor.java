package companies.JPMorgan;

public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {
    public boolean makeTurn(StringBuilder str, char color) {
        if(str.length() < 3) return false;

        for(int i=1; i<str.length()-1; i++) {
            if(str.charAt(i) == color && str.charAt(i-1) == color && str.charAt(i+1) == color) {
                str.deleteCharAt(i);
                return true;
            }
        }

        return false;
    }

    public boolean winnerOfGameBruteForce(String colors) {
        StringBuilder game = new StringBuilder(colors);
        while(true) {
            // make alice's turn
            if(!makeTurn(game, 'A')) {
                return false;
            }

            // make bob's turn
            if(!makeTurn(game, 'B')) {
                return true;
            }
        }
    }

    public boolean winnerOfGame(String colors) {
        int aliceTurnsPossible = 0, bobTurnsPossible = 0;
        int i = 1, n = colors.length();
        while (i < n - 1) {
            if(colors.charAt(i) == colors.charAt(i + 1) && colors.charAt(i) == colors.charAt(i - 1)) {
                int j = i + 1, count = 0;
                while (j < colors.length() && colors.charAt(j) == colors.charAt(i)) {
                    count++;
                    j++;
                }

                if(colors.charAt(i) == 'A') {
                    aliceTurnsPossible += count;
                } else {
                    bobTurnsPossible += count;
                }

                i = j;
            }

            i++;
        }

        return aliceTurnsPossible > bobTurnsPossible;
    }
}
