package leetcode.solved.categorized.hashing;

import java.util.*;

class P128LongestConsecutiveSequence {

    // O(N logN) approach using sorting
    public int longestConsecutiveUsingSorting(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int maxLen = 1, currLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { // Only if the elements are unequal, we need to check if our sequence has extended or brokenre
                if (nums[i] == nums[i - 1] + 1) currLen++;
                else {
                    maxLen = Math.max(currLen, maxLen);
                    currLen = 1;
                }
            }
        }
        return Math.max(currLen, maxLen);
    }

    //O(n) maps based solution
    public int longestConsecutiveUsingHashing(int[] nums) {
        if (nums.length == 0) return 0;

        Map<Integer, Boolean> map = new HashMap<>();

        for (int i : nums) map.put(i, true);
        for (int i : nums) if (map.containsKey(i - 1)) map.put(i, false);

        int maxLen = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == true)
                maxLen = Math.max(maxLen, findMaxLen(map, key));
        }

        return maxLen;
    }

    int findMaxLen(Map<Integer, Boolean> map, int key) {
        int len = 0;
        while (map.containsKey(key)) {
            len++;
            key++;
        }
        return len;
    }

    // Using Graphs : Kosaraju's SCC algorithm
    // EXPLANATION: https://leetcode.com/problems/longest-consecutive-sequence/discuss/560800/find-largest-strongly-connected-component-in-undirected-graph
    // Represent the input array as an undirected graph,
    // connect an edge b/w any two numbers which have a difference of 1 then find the size of largest connected component
    class Solution {
        int length = 0;
        public int longestConsecutive(int[] nums) {
            int maxConnCompLen = 0;
            Map<Integer, LinkedList<Integer>> graph = getAdjList(nums);
            Set<Integer> visited = new HashSet<>();
            for(int vertex : graph.keySet()) {
                if(!visited.contains(vertex)) {
                    length = 0;
                    calConnCompLenDFS(graph, visited, vertex);
                    maxConnCompLen = Math.max(maxConnCompLen, length);
                }
            }
            return maxConnCompLen;
        }

        Map<Integer, LinkedList<Integer>> getAdjList(int[] nums) {
            Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                int vertex = nums[i];
                graph.putIfAbsent(vertex, new LinkedList<>());
            }

            for(int i = 0; i < nums.length; i++) {
                int vertex = nums[i];
                if(graph.containsKey(vertex - 1)) {
                    graph.get(vertex).add(vertex - 1);
                }
                if(graph.containsKey(vertex + 1)) {
                    graph.get(vertex).add(vertex + 1);
                }
            }

            return graph;
        }

        void calConnCompLenDFS(Map<Integer, LinkedList<Integer>> graph, Set<Integer> visited, int vertex) {
            visited.add(vertex);
            length++;
            LinkedList<Integer> neighbors = graph.get(vertex);
            for(int neighbor : neighbors) {
                if(!visited.contains(neighbor)) calConnCompLenDFS(graph, visited, neighbor);
            }
        }
    }
}