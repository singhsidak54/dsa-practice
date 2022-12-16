package companies.Amazon;

public class SubstringWithLargestVariance {
    public int calculateVariance(int[] charMap) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i=0; i<26; i++) {
            if(charMap[i] == 0) {
                continue;
            }

            if(charMap[i] > max) {
                if(min == Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
                    min = max;
                }
                max = charMap[i];
            }

            if(charMap[i] < min) {
                min = charMap[i];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : max - min;
    }

    public int largestVarianceBruteForce(String s) {
        int maxVariance = 0;

        for(int i=0; i<s.length(); i++) {
            int[] charMap = new int[26];
            for(int j=i; j<s.length(); j++) {
                charMap[s.charAt(j) - 'a']++;
                maxVariance = Math.max(maxVariance, calculateVariance(charMap));
            }
        }

        return maxVariance;
    }

    public int largestVarianceKadane(String s) {
        int maxVariance = 0;
        int[] charFreq = new int[26];
        for(int i=0; i<s.length(); i++) {
            charFreq[s.charAt(i) - 'a']++;
        }

        for(char a='a'; a<='z'; a++) {
            for(char b='a'; b<='z'; b++) {
                int remainingA = charFreq[a - 'a'], remainingB = charFreq[b - 'a'];
                if(a == b || remainingA == 0 || remainingB == 0) continue;

                int currentA = 0, currentB = 0;
                for(int i=0; i<s.length(); i++) {
                    char c = s.charAt(i);

                    if(c == b) {
                        currentB++;
                    }

                    if(c == a) {
                        currentA++;
                        remainingA--;
                    }

                    if(currentA > 0) {
                        maxVariance = Math.max(maxVariance, currentB - currentA);
                    }

                    if(currentA > currentB && remainingA > 0) {
                        currentA = 0;
                        currentB = 0;
                    }
                }
            }
        }
        return maxVariance;
    }
}
