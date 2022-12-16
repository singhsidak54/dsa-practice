package companies.Bloomberg;

public class NumberOfShipsInARectangle {
    interface Sea {
        public boolean hasShips(int[] topRight, int[] bottomLeft);
    }

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if(topRight[0] < bottomLeft[0] || topRight[1] < bottomLeft[1]) return 0;
        if(!sea.hasShips(topRight, bottomLeft)) return 0;

        if(topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) return 1;

        int midX = (topRight[0] + bottomLeft[0])/2;
        int midY = (topRight[1] + bottomLeft[1])/2;

        int firstQ = countShips(sea, topRight, new int[] { midX + 1, midY + 1});
        int secondQ = countShips(sea, new int[] {midX, topRight[1]}, new int[] {bottomLeft[0], midY + 1});
        int thirdQ = countShips(sea, new int[] {midX, midY}, bottomLeft);
        int fourthQ = countShips(sea, new int[] {topRight[0], midY}, new int[] {midX + 1, bottomLeft[1]});

        return firstQ + secondQ + thirdQ + fourthQ;
    }
}
