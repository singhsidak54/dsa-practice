package daily.oct24;

import java.util.PriorityQueue;

public class Day15SeparateBlackAndWhiteBalls {
    public long minimumSteps(String s) {
        PriorityQueue<Integer> blackBallIndices = new PriorityQueue<Integer>();
        long ans = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '0' && !blackBallIndices.isEmpty()) {
                int first = blackBallIndices.poll();
                ans += (i - first);
                blackBallIndices.add(i);
            } else if (c == '1') {
                blackBallIndices.add(i);
            }
        }
        return ans;
    }

    public long minimumStepsAlternate(String s) {
        StringBuilder str = new StringBuilder(s);
        int firstBlackBallIndex = -1;
        long ans = 0;

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == '0' && firstBlackBallIndex != -1) {
                ans += (i - firstBlackBallIndex);
                str.setCharAt(i, '1');
                str.setCharAt(firstBlackBallIndex, '0');
                while (firstBlackBallIndex <= i) {
                    if(str.charAt(firstBlackBallIndex) == '1') {
                        break;
                    }
                    firstBlackBallIndex++;
                }
            } else if (c == '1' && firstBlackBallIndex == -1) {
                firstBlackBallIndex = i;
            }
        }
        return ans;
    }


    public long minimumStepsOptimised(String s) {
        long ans = 0;
        int blackBallCount = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0') {
                ans += (blackBallCount);
            } else {
                blackBallCount++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Day15SeparateBlackAndWhiteBalls obj = new Day15SeparateBlackAndWhiteBalls();
        System.out.println(obj.minimumStepsOptimised("10010"));
    }
}