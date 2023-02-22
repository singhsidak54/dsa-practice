package companies.Google;

import java.util.Arrays;
import java.util.Comparator;

public class TheNumberOfWeakCharactersInTheGame {
    public int numberOfWeakCharactersBruteForce(int[][] properties) {
        int n = properties.length;
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        boolean[] weak = new boolean[n];
        for(int i=0; i<properties.length; i++) {
            int maxDef = properties[i][1];
            for(int j=0; j<i && properties[j][0]<properties[i][0]; j++) {
                if(weak[j]) continue;
                if(properties[j][1] < maxDef) {
                    weak[j] = true;
                }
            }
        }

        int count = 0;
        for(int i=0; i<n; i++) {
            if(weak[i]) count++;
        }
        return count;
    }

    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o2[1], o1[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int maxDefense = properties[n-1][1], count = 0;
        for(int i=n-2; i>=0; i--) {
            if(properties[i][1] < maxDefense) {
                count++;
            } else {
                maxDefense = properties[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        TheNumberOfWeakCharactersInTheGame obj = new TheNumberOfWeakCharactersInTheGame();
        int[][] props = {{7,7},{1,2},{9,7},{7,3},{3,10},{4,3},{1,5},{1,5}};
        System.out.println(obj.numberOfWeakCharacters(props));
    }
}
