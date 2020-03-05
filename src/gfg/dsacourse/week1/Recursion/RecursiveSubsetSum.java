package gfg.dsacourse.week1.Recursion;

public class RecursiveSubsetSum {

	public static boolean subsetSum(int arr[], int i, int currSum, int expSum, int n) {
		if (i == n) {
			if (expSum == currSum)
				return true;
			return false;
		}
		if (expSum == currSum)
			return true;
		return subsetSum(arr, i + 1, currSum + arr[i], expSum, n) || subsetSum(arr, i + 1, currSum, expSum, n);
	}

	public static boolean subsetSum(int arr[], int n, int expSum) {
		if (n == 0) {
			if (expSum == 0)
				return true;
			else
				return false;
		}
		return subsetSum(arr, n - 1, expSum - arr[n - 1]) || subsetSum(arr, n - 1, expSum);
	}

	public static void main(String args[]) {
		int set[] = { 99, 34, 15, 12, 5, 2 };
		int sum = 101;
		int n = set.length;
		if (subsetSum(set, n , sum) == true)
			System.out.println("Found a subset" + " with given sum");
		else
			System.out.println("No subset with" + " given sum");
	}
}
