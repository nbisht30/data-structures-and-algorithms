package gfg.dsacourse.week2.Arrays;

import java.util.Scanner;

public class TrappingRainWaterOptimized {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		int itr = 0;
		while (itr < N) {
			arr[itr] = in.nextInt();
			itr++;
		}
		// arr.forEach(item -> System.out.print(item + " "));
		int sum = 0;
//		int leftMax[] = new int[N];
//		int rightMax[] = new int[N];
//		int lm = arr[0], rm = arr[N - 1];
//
//		for (int i = 1; i < N; i++) {
//			if (arr[i] > lm) {
//				lm = arr[i];
//			}
//			leftMax[i] = lm;
//		}
//		System.out.println("Left Max Array:-");
//		for (int i = 0; i < N; i++)
//			System.out.print(leftMax[i] + " ");
//
//		for (int i = N - 2; i >= 0; i--) {
//			if (arr[i] > rm) {
//				rm = arr[i];
//			}
//			rightMax[i] = rm;
//		}
//		System.out.println();
//		System.out.println("Right Max Array:-");
//		for (int i = 0; i < N; i++)
//			System.out.print(rightMax[i] + " ");

		// trying to solve on SC O(1)
		int lg = arr[0], rg = arr[N - 1];
		for (int i = 1; i < N; i++) {
			if (arr[i] > lg) {
				lg = arr[i];
			}
			if (arr[N - i - 1] > rg) {
				rg = arr[N - i - 1];
			}
			if (min(lg, rg) > 0)
				sum += (min(lg, rg) - arr[i]);
			System.out.print(sum + " ");
		}

//		for (int i = 0; i < N; i++) {
//			if (min(leftMax[i], rightMax[i]) > 0)
//				sum += (min(leftMax[i], rightMax[i]) - arr[i]);
//		}
		System.out.println();
		System.out.println(sum);

	}

	public static int min(int a, int b) {
		if (a <= b)
			return a;
		else
			return b;
	}
}
//N = 13
//1 3 7 5 1 3 4 5 2 7 3 1 4