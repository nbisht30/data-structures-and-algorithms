package leetcode.solved.categorized.hashing;

import java.util.HashMap;
import java.util.Map;

class P454FourSumII {

    /*
    Solved myself: But this seems slow
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // In a map store the sums as keys and index pair making them as value in list. Make two such maps, one for lists [A, B] and one for lists [B, C]
        // Iterate over keys for mapAB(if there are multiple pairs present at currKey, then iterate for all pairs at currKey)
        //and check if -1 * currKey, exists in mapCD. If yes, increase counter and remove one pair from value at currKey from mapAB and mapCD
        Map<Integer, Integer> mapAB = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                mapAB.put(A[i] + B[j], mapAB.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }


        Map<Integer, Integer> mapCD = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                mapCD.put(C[i] + D[j], mapCD.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }

        int result = 0;
        for (Integer sum : mapAB.keySet()) {
            if (mapCD.containsKey(sum * -1)) {
                result += mapAB.get(sum) * mapCD.get(sum * -1);
            }
        }
        return result;
    }


    /*
    Optimization: We don't need two maps and the third loop.
     */
    public int fourSumCountOptimized(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> mapAB = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                mapAB.put(A[i] + B[j], mapAB.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        int result = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                result += mapAB.getOrDefault(-1 * (C[i] + D[j]), 0);
            }
        }
        return result;
    }
}