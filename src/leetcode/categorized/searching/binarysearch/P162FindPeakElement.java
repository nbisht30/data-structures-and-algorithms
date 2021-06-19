package leetcode.categorized.searching.binarysearch;

class P162FindPeakElement {
    // MYSELF
    // TIME: 50 minutes.
    // @TODO: Understand the optimised version. https://leetcode.com/problems/find-peak-element/discuss/50232/Find-the-maximum-by-binary-search-(recursion-and-iteration)

    int peak = -1;
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        helper(nums, 0, nums.length - 1);
        return peak;
    }
    
    public void helper(int[] nums, int st, int end){
        if(end == st){
            if(nums.length > 1){
                if((st == 0 && nums[st] > nums[st + 1]) || 
                   (st == nums.length - 1 && nums[st] > nums[st -1])) 
                        peak = st;
                }
           return;
        }
        
        int mid = (st + end) / 2;
        
        if((mid + 1 < nums.length && nums[mid] > nums[mid + 1])
           && (mid > 0 && nums[mid] > nums[mid - 1]))
            peak = mid;
        else{
             helper(nums, st, mid);
             helper(nums, mid + 1, end);
        }
    }
}