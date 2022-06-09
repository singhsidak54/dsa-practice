package ds2;

import java.util.*;

public class KClosestPointsToOrigin {
    public static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    //using heap
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for(int i=0; i< points.length; i++) {
            pq.add(new int[] {distance(points[i]), i});

            if(pq.size() > k) {
                pq.poll();
            }
        }
        int[][] result = new int[k][2];
        for(int i=0; i<k; i++) {
            result[i] = points[pq.poll()[1]];
        }

        return result;
    }

    public static void swap(int[][] points, int i, int j) {
        int[] temp =  points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    //using quick select
    public static int[][] kClosest2(int[][] points, int k) {
        int n = points.length;
        int requiredIndex = k - 1;


        int l = 0, h = n - 1;
        while (l < h) {
            int partitionIndex = partition(points, l, h);
            if(partitionIndex == requiredIndex) {
                break;
            } else if (partitionIndex > requiredIndex) {
                h = partitionIndex - 1;
            } else {
                l = partitionIndex + 1;
            }
        }

        int[][] result = new int[k][2];
        for(int i=0; i<k; i++) {
            result[i] = points[i];
        }

        return result;
    }

    public static int partition(int[][] points, int low, int high) {
        Random rand = new Random();
        int pivotIndex = low + rand.nextInt(high - low);
        int pivotDistance = distance(points[pivotIndex]);
        int j = low;
        swap(points, high, pivotIndex);
        while (low < high) {
            if(distance(points[low]) < pivotDistance) {
                swap(points, low, j);
                j++;
            }
            low++;
        }

        swap(points, high, j);
        return j;
    }

    public static void main(String[] args) {
        int[][] points = {{3,3}, {5,-1}, {-2,4}};
    }
}
