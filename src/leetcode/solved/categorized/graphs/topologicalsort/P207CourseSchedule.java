package leetcode.solved.categorized.graphs.topologicalsort;

import java.util.Stack;

class P207CourseSchedule {
    // Topological sort.
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Count prerequisites for courses that have prerequisites
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;  // [1,0] means an edge pointing from 0 to 1
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) stack.push(i); // push the courses with no prerequisites to the stack initially
        }

        int count = 0;
        while (!stack.isEmpty()) {
            int curr = stack.pop();

            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == curr) { // if a course has prerequisite as curr
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) stack.push(prerequisites[i][0]);
                }
            }

            count++;
        }

        return count == numCourses;
    }
}