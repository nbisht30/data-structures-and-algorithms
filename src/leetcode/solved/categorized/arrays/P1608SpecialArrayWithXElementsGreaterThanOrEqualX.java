package leetcode.solved.categorized.arrays;

class P1608SpecialArrayWithXElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        if(nums.length == 0) return 0;
        
        int n = nums.length;
        
        while(n != 0){
            int cnt = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] >= n) {
                    cnt++;
                }
                if(cnt > n) return -1;
            }
            if(cnt == n) return n;
            n--;
        }
        
        return -1;
    }
}