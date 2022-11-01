package patterns.intuit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int[] inDegree = new int[numCourses];
        List<List<Integer>> neighbours = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            neighbours.add(i, new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites) {
            neighbours.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        int coursesDone = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
                ans[coursesDone] = i;
                coursesDone++;
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for(int neighbour : neighbours.get(curr)) {
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                    ans[coursesDone] = neighbour;
                    coursesDone++;
                }
            }
        }

        if(coursesDone != numCourses) {
            return new int[] {};
        }

        return ans;
    }
}
