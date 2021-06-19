package leetcode.categorized.dp.kadanes;

class P918MaximumSumCircularSubarray {

    // @TODO: Revisit
    // NEEDED HELP
    // COMMENTS: Even though I knew that Kadane's algorithm would be used, could not get the exact trick.
    public static int maxSubarraySumCircular(int[] A) {
        if (A.length == 1) return A[0];
        // The maximum subarray sum in circular array is maximum of following
        // Maximum subarray sum in the original array -> Find using Kadane's algo.
        // Maximum subarray sum in the circular array -> Total sum of the original array - Minimum subarray sum for the original array.
        // You can compute all three items in a single loop.
        // In order to compute the minimum subarray sum for the original array, we just negate each value and find the max, considering
        // the entire array negated. Which gives us the min subarray sum as a positive number. Then we negate this sum and we get the
        // actual min subarray sum.

        // There is an edge case here when all elements in the array are negative, what happens is min subarray sum and total sum of
        // original array cancel each other and you get 0 as the Maximum subarray sum in circular array, and the max of this and
        // max subarray sum of original array would be this 0 as all numbers are negative and max subarray sum of the original array
        // would be a negative number. To handle this case we use a flag and return the maxsubarray sum if the value of this flag remains
        // true.

        int totalSum = A[0];
        boolean allNegFlag = true;
        int maxTillLastIndex = A[0];
        int maxSubSum = Integer.MIN_VALUE;
        int minSubSum = Integer.MIN_VALUE;
        int minTillLastIndex = -1 * A[0];
        if (A[0] >= 0) allNegFlag = false;
        for (int i = 1; i < A.length; i++) {
            if (allNegFlag && A[i] >= 0) allNegFlag = false;
            totalSum += A[i];
            minTillLastIndex = Math.max(minTillLastIndex + (-1 * A[i]), -1 * A[i]);
            maxTillLastIndex = Math.max(maxTillLastIndex + A[i], A[i]);
            if (maxSubSum < maxTillLastIndex) maxSubSum = maxTillLastIndex;
            if (minSubSum < minTillLastIndex) minSubSum = minTillLastIndex;
        }
        if (allNegFlag) return maxSubSum;

        minSubSum *= -1;

        int maxSubSumCir = totalSum - minSubSum;

        return Math.max(maxSubSum, maxSubSumCir);
    }
}