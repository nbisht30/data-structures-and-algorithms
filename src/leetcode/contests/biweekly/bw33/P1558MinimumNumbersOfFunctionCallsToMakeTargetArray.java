package leetcode.contests.biweekly.bw33;

class P1558MinimumNumbersOfFunctionCallsToMakeTargetArray {
    public int minOperations(int[] nums) {
        int opns = 0;
        while (true) {
            int z = 0;
            int i;
            for (i = 0; i < nums.length; i++) {
                if (nums[i] % 2 != 0) {
                    break;
                } else if (nums[i] == 0) {
                    z++;
                }
            }
            if (z == nums.length) {
                return opns;
            }
            if (i == nums.length) {
                for (int j = 0; j < nums.length; j++) {
                    nums[j] = nums[j] / 2;
                }
                opns++;
            }
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 != 0) {
                    nums[j]--;
                    opns++;
                }
            }
        }
    }
}