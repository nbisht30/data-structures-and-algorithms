package hackerearth.inputoutput.basicsofprogramming;

import java.util.Arrays;
import java.util.Scanner;

/*
 * This problem uses the concept of Greedy Algorithm 
 * */
public class MinimizeCostGreedy {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), k = in.nextInt();
		long A[] = new long[n];
		long T[] = new long[n];
		// INPUT THE ARRAY
		for (int i = 0; i < n; i++) {
			A[i]=in.nextLong();
		}
		Arrays.sort(A);
		for (int i = 0; i < n; i++) {
			System.out.println(A[i]);
		}
		
		
		
		
	}
}
