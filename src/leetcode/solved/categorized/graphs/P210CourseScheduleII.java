package leetcode.solved.categorized.graphs;

import java.util.Stack;

class P210CourseScheduleII {
    // Did myself.
    // Application of topological sort.
    // @TODO: Look to optimize this.
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int k = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                result[k++] = i;
                count++;
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == curr) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        stack.push(prerequisites[i][0]);
                        result[k++] = prerequisites[i][0];
                        count++;
                    }
                }
            }
        }

        return count != numCourses ? new int[]{} : result;
    }
}