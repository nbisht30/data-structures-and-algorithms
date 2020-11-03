package leetcode.solved.categorized.greedy;

class P55JumpGame {
    public boolean canJump(int[] nums) {
        return approachB(nums);
    }
    
    boolean approachA(int[] nums){
        int n = nums.length;
        int canReach = 0;
        for(int i = 0; i <= canReach; i++){
            if(i == n - 1) return true;
            canReach = Math.max(canReach, i + nums[i]);
        }
        return false;
    }
    
    // Faster implementation
    boolean approachB(int[] nums){
        int size = nums.length;
        int lastGoodIndex = size - 1;
        for(int i = size - 1; i >=0; i--){
            if(i + nums[i] >= lastGoodIndex) lastGoodIndex = i;
        }
        return lastGoodIndex == 0;
    }
    
}