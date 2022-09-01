package gt1;

public class FloodFill {
    public static boolean isValidPixel(int row, int col, int m, int n) {
        return (row >= 0 && row < m && col >= 0 && col < n);
    }
    public static void floodFillHelper(int[][] image, int row, int col, int newColor, int oldColor) {
        if(isValidPixel(row, col, image.length, image[0].length)
                && image[row][col] == oldColor) {
            image[row][col] = newColor;
            floodFillHelper(image, row + 1, col, newColor, oldColor);
            floodFillHelper(image, row - 1, col, newColor, oldColor);
            floodFillHelper(image, row, col + 1, newColor, oldColor);
            floodFillHelper(image, row, col - 1, newColor, oldColor);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] != color) {
            floodFillHelper(image, sr, sc, color, image[sr][sc]);
        }
        return image;
    }
}
