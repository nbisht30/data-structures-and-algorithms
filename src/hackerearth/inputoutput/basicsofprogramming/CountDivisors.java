package hackerearth.inputoutput.basicsofprogramming;

import java.util.Scanner;

public class CountDivisors {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int l;
		l = in.nextInt();
		System.out.println(factorial(l));
	}

	static int factorial(int n) {
		if (n == 0)
			return 1;
		return n * factorial(n - 1);
	}
}
