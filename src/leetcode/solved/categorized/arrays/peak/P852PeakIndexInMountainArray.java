package leetcode.solved.categorized.arrays.peak;

class P852PeakIndexInMountainArray {
    // MYSELF
    // Time: 5 min

    public int peakIndexInMountainArray(int[] A) {
        int peak = Integer.MIN_VALUE;
        int ind = 0;
        for(int i = 0; i < A.length; i++) {
            if(peak < A[i]) {
            ind = i;
            peak = A[i];
            }
        }
        
        return ind;
    }
}