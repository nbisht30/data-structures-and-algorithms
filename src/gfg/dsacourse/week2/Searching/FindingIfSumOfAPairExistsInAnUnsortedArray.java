package gfg.dsacourse.week2.Searching;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindingIfSumOfAPairExistsInAnUnsortedArray {

	/*
	 * Given an unsorted array and a number x we need to find if there is a pair in
	 * the array with sum equal to x
	 * 
	 * IP: 3,5,9,2,8,10,11 x = 17 OP: true
	 */

	public static boolean myApproach(int arr[], int x) { 
		// Using Hashing O(n) time and space complexity
		Map<Integer, Integer> differenceCheck = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			differenceCheck.put(arr[i], x - arr[i]);
		}

		for (Integer key : differenceCheck.keySet()) {
			return differenceCheck.containsKey(differenceCheck.get(key));
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[] = { 3, 5, 9, 2, 8, 10, 11 };
		int x = 1;
		System.out.println(myApproach(arr, x));
	}
}
