package leetcode.thirtydaychallengemay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
// https://leetcode.com/problems/find-the-town-judge/
class Day10_P997FindTheTownJudge {
    
    public int findJudge(int N, int[][] trust) {
        int[] indegree = new int[N + 1];
        int[] outdegree = new int[N + 1];
        
        for(int i = 0; i < trust.length; i++){
            outdegree[trust[i][0]]++;
            indegree[trust[i][1]]++;
        }
        
        for(int i = 1; i <= N; i++){
            if(indegree[i] == N - 1 && outdegree[i] == 0){
                return i;
            }
        }
        
        return -1;
    }
    
    // Slow: Wasnt aware of indegree and outdegree properties of graph
    public int findJudgeMyImpl(int N, int[][] trust) {
        if(trust.length == 0) return 1;
        Set<Integer> theyTrust = new HashSet<>();
        Map<Integer, Set<Integer>> theyAreTrustedAndBy = new HashMap<>();
        
        // [a,b] -> a trusts b
        
        for(int i = 0; i < trust.length; i++){
            theyTrust.add(trust[i][0]);
            if(theyAreTrustedAndBy.containsKey(trust[i][1])){
                Set<Integer> temp = theyAreTrustedAndBy.get(trust[i][1]);
                temp.add(trust[i][0]);
            }else{
                Set<Integer> newSet = new HashSet<>();
                newSet.add(trust[i][0]);
                theyAreTrustedAndBy.put(trust[i][1], newSet);
            }    
        }
        int totalJudge = 0;
        int judge = 0;
        for (Integer person: theyAreTrustedAndBy.keySet()) {
            if(!theyTrust.contains(person)) {
                if(theyAreTrustedAndBy.get(person).size() == theyTrust.size()) {
                    judge = person;
                    totalJudge ++;
                    if(totalJudge == 2) return -1;
                }
            }
        }
        if(totalJudge == 1) return judge;
        return -1;
    }
}