package patterns.intuit;

import java.util.*;

public class CourseSchedule {
    public void bfs(List<List<Integer>> neighbours, int course, int[] inDegree, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(course);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;
            for(int neighbour : neighbours.get(curr)) {
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        List<List<Integer>> neighbours = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            neighbours.add(new ArrayList<>());
        }

        for(int[] preReq: prerequisites) {
            neighbours.get(preReq[1]).add(preReq[0]);
            inDegree[preReq[0]]++;
        }

        for(int i=0; i<numCourses; i++) {
            if(inDegree[i] == 0 && !visited[i]) {
                bfs(neighbours, i, inDegree, visited);
            }
        }

        for(int i=0; i<numCourses; i++) {
            if(inDegree[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] preReqs = {{1,0}, {2,1}};
    }
}
