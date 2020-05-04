package hackerearth.inputoutput.basicsofprogramming;

import java.util.Scanner;

public class BestIndexUsingPrefixSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long A[] = new long[n];

		// INPUT THE ARRAY
		for (int i = 0; i < n; i++) {
			A[i] = in.nextLong();
		}
		// CALCULATE THE REVERSE PREFIX SUM ARRAY
		for (int i = n - 2; i >= 0; i--) {
			A[i] = A[i] + A[i + 1];
		}
//		for (int i : A) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		System.out.println("----------------");
		// CALCULATING SPECIAL SUM
		int k = 2, j = 0;
		long max=A[n-1];
		for (int i = 0; i < n; i++) {
			for (j = i; (j + k) < n; j = j + k++) {

			}
			if (j < n - 1)
				A[i] = A[i] - A[j + 1];
			if (A[i] > max)
				max = A[i];
			k = 2;
		}
//		for (int i : A) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		System.out.println("----------------");
		System.out.println(max);

	}

}
