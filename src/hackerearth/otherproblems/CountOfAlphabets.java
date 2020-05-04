package hackerearth.otherproblems;

import java.util.Scanner;

public class CountOfAlphabets {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		char prevChar = s.charAt(0);
		int count = 0;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (prevChar == s.charAt(i)) {
				count++;

			} else {
				System.out.print(count + "" + prevChar+",");
				count = 1;
			}
			prevChar = s.charAt(i);
		}
		System.out.print(count + "" + prevChar);
	}
}
