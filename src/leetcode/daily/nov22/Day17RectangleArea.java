package daily.nov22;

public class Day17RectangleArea {
    public int calculateArea(int x1, int y1, int x2, int y2) {
        int l = Math.abs(x2 - x1);
        int b = Math.abs(y2 - y1);

        return l * b;
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // find length and breadth of overlapping area
        int lOverlap = Math.max(Math.min(ax2, bx2) - Math.max(ax1, bx1), 0);
        int bOverlap = Math.max(Math.min(ay2, by2) - Math.max(ay1, by1), 0);

        return calculateArea(ax1, ay1, ax2, ay2) + calculateArea(bx1, by1, bx2, by2) - lOverlap * bOverlap;
    }
}
