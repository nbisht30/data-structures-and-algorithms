package leetcode.thirtydaychallengeapril;

/**
 * @author Nikhil Bisht
 * @date 03-04-2020
 */
/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

public class Day3MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1, -3, 2, 1, -1}, 0, 4));
//        System.out.println(maxSubArrayBruteForce(new int[]{-2, 1}));
    }

    //1. Brute Force Solution - my implementation
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

    public static int maxSubArray(int n[], int start, int end) {
        /*
        //Recursive DP implementation - My Impl. O(n), but more space iterative solution below
        //Intuition - Getting max subarray sum value till each index in a new array(memoization) and then find the max in this array.
        // This is the overall maximum sum. This is a DP approach. just that we are finding the memoization array using recursion.
        //The ideas is that the Maximum subarray sum found on iterating the given array till index n = The largest between
        //[(Max subarray sum found till index n-1) + Value at index n] and [Value at index n]
        int[] maxTillIndexArray = new int[n.length];
        maxSubArrayTillSize(n, n.length, maxTillIndexArray);
        */

        /*
        //Iterative DP implementation -> O(n)
        //Intuition - Same as above just that we're creating the memoize array iteratively.
        int[] maxTillIndexArray = new int[n.length];
        maxTillIndexArray[0] = n[0];
        int max = maxTillIndexArray[0];
        for (int i = 1; i < n.length; i++) {
            maxTillIndexArray[i] = (maxTillIndexArray[i - 1] + n[i]) > n[i] ? (maxTillIndexArray[i - 1] + n[i]) : n[i];
            if (maxTillIndexArray[i] > max) {
                max = maxTillIndexArray[i];
            }
        }*/


        //Kadane's Algorithm - O(n) time O(1) space.
        //Intuitiion -Instead of the above solution that needs an extra array for memoization
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
        int s = str.length();
        return max;




        /*
        //Divide and Conquer -> O(nlogn)
        // Intuition :
        if (end - start == 1) {
            return n[start] > n[end] ? n[start] : n[end];
        }
        if (end == start) {
            return n[start];
        }

        int maxLeftSum = maxSubArray(n, start, end / 2);
        int maxRightSum = maxSubArray(n, (end / 2) + 1, end);
        int maxSumForCrossingSubarray = sumMiddle(n, start, end);  //O(n): runs n times in each iteration where n = end + 1 - start

        System.out.println("Start: " + start + " End: " + end);
        System.out.println("ML: " + maxLeftSum + " MR: " + maxRightSum + " MC: " + maxSumForCrossingSubarray);

        if (maxLeftSum > maxRightSum && maxLeftSum > maxSumForCrossingSubarray)
            return maxLeftSum;
        else if (maxRightSum > maxLeftSum && maxRightSum > maxSumForCrossingSubarray)
            return maxRightSum;
        else
            return maxSumForCrossingSubarray;
         */
    }


    public static int sumMiddle(int n[], int start, int end) {
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


    public static int[] maxSubArrayTillSize(int n[], int size, int tillIndices[]) { //recursive
        if (size == 1) {
            tillIndices[0] = n[0];
            return tillIndices;
        }
        tillIndices = maxSubArrayTillSize(n, size - 1, tillIndices);
        tillIndices[size - 1] = n[size - 1] > (tillIndices[size - 1 - 1] + n[size - 1]) ? n[size - 1] : tillIndices[size - 1 - 1] + n[size - 1];
        return tillIndices;
    }

}
