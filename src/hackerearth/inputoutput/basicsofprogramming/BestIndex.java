package hackerearth.inputoutput.basicsofprogramming;

import java.util.Scanner;

public class BestIndex {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int A[] = new int[n];

		// INPUT THE ARRAY
		for (int i = 0; i < n; i++) {
			A[i] = in.nextInt();
		}
		// CALCULATE THE SPECIAL SUM FOR EACH INDEX
		int max = 0;
		//int ind = in.nextInt();
		int B[] = new int[n];
		for (int i = 0; i < n; i++) {
			B[i] = indexSpecialSum(A, i, n);
			if (B[i] > max) {
				max = B[i];
			}
			//System.out.println(B[i]);
		}
		System.out.println(max);
		//System.out.println("Final : " + indexSpecialSum(A, ind, n));

	}
	
	//BRUTE FORCE 
	public static int indexSpecialSum(int A[], int x, int n) {
		int sum = A[x], k = 1, z = 2;
		for (int i = x; (k + z + x) <= n; i++) { // i+k causing problem
			for (int j = 1; j <= z; j++) {
				sum += A[x + k];
				k++;
			}
			z++;
		}
		return sum;
	}
	
	//USING PREFIX SUM
}
