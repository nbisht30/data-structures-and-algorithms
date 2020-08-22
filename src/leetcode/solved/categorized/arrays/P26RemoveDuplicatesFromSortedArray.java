package leetcode.solved.categorized.arrays;

class P26RemoveDuplicatesFromSortedArray {
    //MFSELF
    //TIME: 18 mins
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
}