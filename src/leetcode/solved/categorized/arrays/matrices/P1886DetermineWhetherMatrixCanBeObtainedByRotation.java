package leetcode.solved.categorized.arrays.matrices;

class P1886DetermineWhetherMatrixCanBeObtainedByRotation {
    // MYSELF
    // TIME: 15 mins
    // DATE: 12-06-21, first attempt
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i = 0; i < 5; i++) {
            if(isEqual(mat, target)) return true;
            mat = rotateNinetyDegree(mat);
        }
        return false;
    }

    // @TODO: Need to memorize matrix rotation algorithms
    int[][] rotateNinetyDegree(int[][] m) {
        int[][] n = new int[m.length][m.length];
        for(int i = 0; i < m.length; i++) {
            for(int j = 0, k = m.length - 1; j < m.length && k >= 0; j++, k--) {
                n[i][j] = m[k][i];
            }
        }
        return n;
    }
    
    boolean isEqual(int[][] m, int[][] n) {
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m.length; j++) {
                if(m[i][j] != n[i][j]) return false;
            }
        }
        return true;
    }
}