package leetcode.categorized.arrays.sortedarrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = 0, itr = 0, k = 1;
        while(itr < nums.length) {
            if(nums[itr] == nums[prev]) {
                itr++;
            } else {
                nums[k] = nums[itr];
                prev = itr;
                itr++;
                k++;
            }
        }
        return k;
    }
}