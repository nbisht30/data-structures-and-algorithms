package leetcode.contests.biweekly.bw33;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class P1557MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
      /*
        INTUITION: The input is a Directed Acyclic Graph(DAG). Which means there wont be any cycle in the graph and you can only go to specific directions.

        Properties of Graph:-
        In-degree: number of edges coming into a node
        Out-degree: number of edges coming out of a node

        So, if there is no indegree for a node it means that it cannot be reached from any other node and has to be part of the solution set.
      */
        
        //Finding nodes with no indegree
        Set<Integer> set = new HashSet<>();
        
        for(List<Integer> edge: edges) set.add(edge.get(1));
        
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!set.contains(i)) res.add(i);
        }
        
        return res;
    }


    // MYSELF
    // DATE: 21-05-2021, second attempt
    // TIME: 6 mins

    public List<Integer> findSmallestSetOfVerticesSecondAttempt(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        for(List<Integer> edge : edges) {
            indegree[edge.get(1)]++;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) res.add(i);
        }
        return res;
    }
}