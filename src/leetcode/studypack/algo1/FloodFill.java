package algo1;

import java.util.Arrays;

// Problem Link - https://leetcode.com/problems/flood-fill/
public class FloodFill {
    public static void floodFillHelper(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if(sr == image.length) return;
        if(sc == image[sr].length) return;

        if(image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            if(sr - 1 >= 0) {
                floodFillHelper(image, sr-1, sc,newColor, oldColor);
            }

            if(sr + 1 <= image.length - 1) {
                floodFillHelper(image, sr+1, sc,newColor, oldColor);
            }

            if(sc - 1 >= 0) {
                floodFillHelper(image, sr,sc-1, newColor, oldColor);
            }

            if(sc + 1 <= image[sr].length - 1) {
                floodFillHelper(image, sr,sc+1, newColor, oldColor);
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor != newColor) {
            floodFillHelper(image, sr,sc, newColor, oldColor);
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        floodFill(image, 1, 1, 2);
        for(int[] row : image) {
            System.out.println(Arrays.toString(row));
        }
    }
}
