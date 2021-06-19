package leetcode.categorized.arrays;

class P565ArrayNesting {
    /* O(n^2) solution: 
    In worst case, for example: [1,2,3,4,5,0], loop body will be executed n^2n times.
    */
    public int arrayNestingQuadratic(int[] nums) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            int nextIndex = nums[i];
            while (i != nextIndex) {
                nextIndex = nums[nextIndex];
                len++;
            }
            maxLen = Math.max(maxLen, len);
            if (maxLen == nums.length) return maxLen;
        }
        return maxLen;
    }

    /*
    O(N) approach: Keep marking the elements you've visited from a replacement
    value which can be 20,001 in this case as a[i] goes from 0 to 20000.
    Marking helps avoid recalculation of length for the set of current element
    if it was already visited earlier and was part of that set.
    Read Leetcode's article for more understanding.
    */
    public int arrayNesting(int[] nums) {
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 20001) {
                int len = 1, startIndex = i, nextIndex = nums[i];
                nums[i] = 20001;
                while (startIndex != nextIndex) {
                    int tempNextIndex = nums[nextIndex];
                    nums[nextIndex] = 20001; // Mark visited
                    nextIndex = tempNextIndex; // Getting actual next index
                    len++;
                }
                maxLen = Math.max(maxLen, len);
                if (maxLen == nums.length) return maxLen;
            }

        }
        return maxLen;
    }

}