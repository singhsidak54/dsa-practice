package daily.feb23;

public class Day27ConstructQuadTree {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public int countOnes(int[][] grid, int topR, int topC, int botR, int botC) {
        int count = 0;
        for(int i=topR; i<=botR; i++) {
            for(int j=topC; j<=botC; j++) {
                if(grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public Node construct(int[][] grid, int[] topLeft, int[] bottomRight) {
        int n = bottomRight[1] - topLeft[1] + 1;
        int size = n * n;
        int ones = countOnes(grid, topLeft[0], topLeft[1], bottomRight[0], bottomRight[1]);

        if(ones == size) {
            return new Node(true, true);
        } else if(ones == 0) {
            return new Node(false, true);
        } else {
            Node tL = construct(grid, topLeft, new int[] {bottomRight[0] - n/2, bottomRight[1] - n/2});
            Node tR = construct(grid, new int[] {topLeft[0], topLeft[1] + n/2}, new int[] {bottomRight[0] - n/2, bottomRight[1]});
            Node bL = construct(grid, new int[] {topLeft[0] + n/2, topLeft[1]}, new int[] {bottomRight[0], bottomRight[1] - n/2});
            Node bR = construct(grid, new int[] {topLeft[0] + n/2, topLeft[1] + n/2}, bottomRight);

            return new Node(false, false, tL, tR, bL, bR);
        }
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        return construct(grid, new int[] {0,0}, new int[] {n-1, n-1});
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};
        Day27ConstructQuadTree obj = new Day27ConstructQuadTree();
        Node node = obj.construct(grid);
        System.out.println(node);
    }
}
