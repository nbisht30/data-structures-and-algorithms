package leetcode.solved.categorized.graphs.topologicalsort;

import java.util.*;

class P207CourseSchedule {
    // Topological sort.
    //https://www.youtube.com/watch?v=rG2-_lgcZzo&ab_channel=NideeshTerapalli
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
            int currTop = stack.pop();

            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == currTop) { // if a course has prerequisite as currTop
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) stack.push(prerequisites[i][0]);
                }
            }

            count++;
        }

        return count == numCourses;
    }

    /*
    Queue based implementation (BFS) is much faster.
    */
    public boolean canFinishUsingQueueAndAdjList(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> edgesFromNode = new HashMap<>(); // Adjacency list : Which nodes a particular node leads to
        int[] indegree = new int[numCourses];

        // Count indegree and prepare adjacency list
        for(int i = 0; i < prerequisites.length; i++){
            edgesFromNode.putIfAbsent(prerequisites[i][0], new ArrayList<>());
            edgesFromNode.get(prerequisites[i][0]).add(prerequisites[i][1]);

            indegree[prerequisites[i][1]]++;
        }

        // Add nodes with indegree = 0 to the queue
        Queue<Integer> zeroDegreeNodes = new LinkedList<>();
        int countDeleted = 0;
        for(int i = 0 ; i < numCourses; i++) {
            if(indegree[i] == 0) {
                zeroDegreeNodes.offer(i);
                countDeleted++;
            }
        }

        while(!zeroDegreeNodes.isEmpty()){
            int currNode = zeroDegreeNodes.poll();
            ArrayList<Integer> nodesFromCurr = edgesFromNode.get(currNode);

            // Iterate through the nodes current node leads to and decrease their indegree as we have broken an edge from the currentNode.
            for(int i = 0; nodesFromCurr!= null && i < nodesFromCurr.size(); i++){
                indegree[nodesFromCurr.get(i)]--;
                // Add again to queue if indegree for that node becomes 0
                if(indegree[nodesFromCurr.get(i)] == 0) {
                    zeroDegreeNodes.offer(nodesFromCurr.get(i));
                    countDeleted++;
                }
            }
        }

        return countDeleted == numCourses;
    }
}