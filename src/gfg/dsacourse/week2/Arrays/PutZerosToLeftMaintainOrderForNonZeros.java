package gfg.dsacourse.week2.Arrays;

public class PutZerosToLeftMaintainOrderForNonZeros {
	/*
	 * Given an array of integers we need to move all the zeroes to the end and
	 * maintain the order of rest of the elements. Needless to say it should be an
	 * in-place solution.
	 */

	public static void zerosToLeft(int arr[]) {
		int n = arr.length;
		int nonZeroCounter = arr.length - 1;

		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] != 0) {
				arr[nonZeroCounter--] = arr[i];
			}
		}
		for (int i = 0; i < nonZeroCounter + 1; i++)
			arr[i] = 0;

	}

	public static void main(String[] args) {
		int arr[] = { 5, 1, 2, 0, 3, 0, 1, 0, 0, 0 };
		zerosToLeft(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}
}
