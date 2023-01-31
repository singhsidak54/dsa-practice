package daily.jan23;

import java.util.Arrays;

public class Day25FindClosestNodeToGivenTwoNodes {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] distance1 = new int[n];
        int[] distance2 = new int[n];
        Arrays.fill(distance1, n + 1);
        Arrays.fill(distance2, n + 1);

        int dist = 0, currNode = node1;
        while (currNode != -1 && distance1[currNode] == n + 1) {
            distance1[currNode] = dist;
            dist++;
            currNode = edges[currNode];
        }

        dist = 0;
        currNode = node2;
        while (currNode != -1 && distance2[currNode] == n + 1) {
            distance2[currNode] = dist;
            dist++;
            currNode = edges[currNode];
        }

        int minIndex = -1, ans = n + 1;
        for(int i=0; i<n; i++) {
            int maxDistFromNode = Math.max(distance1[i], distance2[i]);
            if(ans > maxDistFromNode) {
                ans = maxDistFromNode;
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        Day25FindClosestNodeToGivenTwoNodes obj = new Day25FindClosestNodeToGivenTwoNodes();
        int[] edges = {4,4,8,-1,9,8,4,4,1,1};
        System.out.println(obj.closestMeetingNode(edges, 5, 6));
    }
}
