package gfg.dsacourse.week2.Arrays;

public class MaxSumKElementsSlidingWindow {

	public static int maxSumWithK(int arr[], int n, int k) {
		int curSum = 0, maxSum;
		for (int i = 0; i < k; i++) {
			curSum += arr[i];
		}
		maxSum = curSum;
		for (int i = 0; i < n - k; i++) {
			curSum = curSum - arr[i] + arr[i + k];
			if (curSum > maxSum)
				maxSum = curSum;
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, -10, -3 };
		int k = 3;
		System.out.println(maxSumWithK(arr, arr.length, k));
	}
}
