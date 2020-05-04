package hackerearth.inputoutput.basicsofprogramming;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		palindromeNaive(in.nextLine());
	}

	public static void palindromeNaive(String str) {
		boolean flag = true;
		int l = str.length();
		for (int i = 0; i < l; i++) {
			if (!(str.charAt(i) == str.charAt(l - i - 1))) {
				flag = false;
				break;
			}
		}
		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
