package leetcode.categorized.arrays.twopointers;

class P26RemoveDuplicatesFromSortedArray {
    // MYSELF
    // TIME: 18 mins
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int pos = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[pos]) {
                nums[++pos] = nums[i];
            }
        }
        return pos + 1;
    }

    // MYSELF
    // DATE: 19-10-23, second attempt
    // TIME: 5:53 mins
    public int removeDuplicates2(int[] nums) {
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