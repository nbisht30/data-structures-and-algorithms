package leetcode.categorized.hashing;

class P645SetMismatch {
    // MYSELF
    // 5 mins
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) {
                res[j++] = index + 1;
            } else nums[index] = -1 * nums[index];
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) {
                res[1] = i + 1;
            }
        }
        return res;
    }
}