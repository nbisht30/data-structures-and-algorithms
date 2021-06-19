package leetcode.categorized.arrays;

class P1608SpecialArrayWithXElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        for(int i = nums.length; i >= 0; i--){
            int numsGreaterThanOrEqualToI = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[j] >= i) numsGreaterThanOrEqualToI++;
            }
            if(numsGreaterThanOrEqualToI == i) return i;
        }
        return -1;
    }
}