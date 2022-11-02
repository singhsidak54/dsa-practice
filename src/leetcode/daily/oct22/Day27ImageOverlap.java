package daily.oct22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day27ImageOverlap {
    public int getOverlap(int[][] img1, int[][] img2, int rowOffset, int colOffset) {
        int overlap = 0;
        for(int i=0; i<img1.length; i++) {
            for(int j=0; j<img1[i].length; j++) {
                if((i + rowOffset < 0 || i + rowOffset >= img1.length) || (j + colOffset < 0) || (j + colOffset >= img1[i].length)) {
                    continue;
                }

                if(img1[i + rowOffset][j + colOffset] + img2[i][j] == 2) {
                    overlap++;
                }
            }
        }

        return overlap;
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        int largestOverlap = 0;

        for(int yShift=-img1.length+1; yShift<img1.length; yShift++) {
            for(int xShift=-img1[0].length+1; xShift<img1[0].length; xShift++) {
                largestOverlap = Math.max(largestOverlap, getOverlap(img1, img2, yShift, xShift));
            }
        }

        return largestOverlap;
    }

    public List<int[]> getOnes(int[][] image) {
        List<int[]> res = new ArrayList<>();
        for(int i=0; i<image.length; i++) {
            for(int j=0; j<image[i].length; j++) {
                if(image[i][j] == 1) {
                    res.add(new int[] { i, j });
                }
            }
        }

        return res;
    }

    public int largestOverlapTimeOptimised(int[][] img1, int[][] img2) {
        List<int[]> aOnes = getOnes(img1);
        List<int[]> bOnes = getOnes(img2);

        HashMap<String, Integer> groupCounter = new HashMap<>();
        int largestGroupSize = 0;
        for(int i=0; i<aOnes.size(); i++) {
            for(int j=0; j<bOnes.size(); j++) {
                int xDiff = aOnes.get(i)[0] - bOnes.get(j)[0];
                int yDiff = aOnes.get(i)[1] - bOnes.get(j)[1];
                String key = xDiff + "-" + yDiff;
                groupCounter.put(key, groupCounter.getOrDefault(key, 0) + 1);
            }
        }

        for(int count : groupCounter.values()) {
            largestGroupSize = Math.max(largestGroupSize, count);
        }

        return largestGroupSize;
    }
}
