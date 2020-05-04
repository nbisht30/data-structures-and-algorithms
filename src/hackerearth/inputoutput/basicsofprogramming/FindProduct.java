package hackerearth.inputoutput.basicsofprogramming;

import java.util.Scanner;

public class FindProduct {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int arr[] = new int[size];
		long product = 1;  //very important to make type long, for large numbers.
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
			product = (long)((product * arr[i]) % (Math.pow(10.0, 9.0) + 7));
		}
		System.out.println(product);
	}
}
