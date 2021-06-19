package leetcode.categorized.dp.kadanes;

/**
 * @author Nikhil Bisht
 * @date 03-04-2020
 */

public class P53MaximumSubarray {
    // DATE: 18-Nov-20, second attempt

    //1. Brute Force Solution
    public static int maxSubArrayBruteForce(int[] nums) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sumTillJ = 0;
            for (int j = i; j < nums.length; j++) {
                if (sumTillJ + nums[j] > maxSum) {
                    maxSum = sumTillJ + nums[j];
                }
                sumTillJ += nums[j];
            }
        }
        return maxSum;
    }

    //2. Kadane's algorithm, TC: O(n), SC: O(n)
    public int maxSubArray(int[] nums) {
        //The ideas is that the Maximum subarray sum found on iterating the given array till index n = The largest between
        //[(Max subarray sum found till index n-1) + Value at index n] and [Value at index n]
        if (nums.length == 0) return 0;
        int max = nums[0];
        int[] maxTillIndex = new int[nums.length];
        maxTillIndex[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxTillIndex[i] = Math.max(maxTillIndex[i - 1] + nums[i], nums[i]);
            max = Math.max(maxTillIndex[i], max);
        }
        return max;
    }

    //3. Kadane's algorithm, TC: O(n), SC: Space optimized to O(1)
    public static int maxSubArray(int n[], int start, int end) {
        //INTUITION -Instead of the above solution that needs an extra array for memoization
        //we can just use a single variable as we only need the value of max sum till last(maxTillLastIndex)
        //index and because we're finding the overall max simultaneously in the above for loop.
        //This is actual Kadane's algorithm, and is the most efficient solution to this problem for time and space.
        int maxTillLastIndex = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n.length; i++) {
            maxTillLastIndex = Math.max((maxTillLastIndex + n[i]), n[i]);
            if (maxTillLastIndex > max) {
                max = maxTillLastIndex;
            }
        }
        String str = "xyz";
        str.toCharArray();
        return max;
    }


    //4. Divide and Conquer -> O(nlogn)
    public static int maxSubArrayDC(int n[], int start, int end) {
        if (end - start == 1) {
            return n[start] > n[end] ? n[start] : n[end];
        }
        if (end == start) {
            return n[start];
        }

        int maxLeftSum = maxSubArrayDC(n, start, end / 2);
        int maxRightSum = maxSubArrayDC(n, (end / 2) + 1, end);
        int maxSumForCrossingSubarray = sumMiddleDC(n, start, end);  //O(n): runs n times in each iteration where n = end + 1 - start

        if (maxLeftSum > maxRightSum && maxLeftSum > maxSumForCrossingSubarray)
            return maxLeftSum;
        else if (maxRightSum > maxLeftSum && maxRightSum > maxSumForCrossingSubarray)
            return maxRightSum;
        else
            return maxSumForCrossingSubarray;
    }

    public static int sumMiddleDC(int n[], int start, int end) {
        int mid = end / 2;
        int leftMaxSum = Integer.MIN_VALUE, rightMaxSum = Integer.MIN_VALUE, sum = 0;
        for (int i = mid; i >= start; i--) {
            sum += n[i];
            if (sum > leftMaxSum) {
                leftMaxSum = sum;
            }
        }
        sum = 0;
        for (int i = mid + 1; i <= end; i++) {
            sum += n[i];
            if (sum > rightMaxSum) {
                rightMaxSum = sum;
            }
        }
        return rightMaxSum + leftMaxSum;
    }

}
