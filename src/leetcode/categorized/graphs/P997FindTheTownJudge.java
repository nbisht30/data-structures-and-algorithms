package leetcode.categorized.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class P997FindTheTownJudge {

    // Indegree and out degree property of graphs: Person with indegree from all remaining persons and outdegree of 0 is the answer
    public int findJudge(int N, int[][] trust) {
        int[] trusts = new int[N + 1];
        int[] trusted = new int[N + 1];
        for (int i = 0; i < trust.length; i++) {
            trusts[trust[i][0]]++;
            trusted[trust[i][1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (trusted[i] - trusts[i] == N - 1) return i;
        }

        return -1;
    }
}