package leetcode.solved.categorized.greedy;

class P1664WaysToMakeAFairArray {
    public int waysToMakeFair(int[] nums) {
        int oddSum = 0, evenSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) evenSum += nums[i];
            else oddSum += nums[i];
        }
        int count = 0;
        int currEven = 0, currOdd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                currEven += nums[i];
                int newOdd = currOdd + evenSum - currEven;
                int newEven = currEven  - nums[i] + oddSum - currOdd;
                if (newOdd == newEven) count++;
            } else {
                currOdd += nums[i];
                int newOdd = currOdd - nums[i] + evenSum - currEven;
                int newEven = currEven + oddSum - currOdd;
                if (newOdd == newEven) count++;
            }
        }
        return count;
    }
}