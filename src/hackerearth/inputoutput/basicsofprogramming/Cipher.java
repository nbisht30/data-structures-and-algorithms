package hackerearth.inputoutput.basicsofprogramming;

import java.util.Scanner;

public class Cipher {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String newStr = "";
		int k = in.nextInt(), l = s.length();
		int offset = 0;
		char ch;
		for (int i = 0; i < l; i++) {
			ch = s.charAt(i);
			if (Character.isLowerCase(ch)) {
				if ((ch + k) > 122) {
					offset = (k - (122 - (int) ch) - 1) % 26;
					newStr += (char) ('a' + offset);
				} else
					newStr += (char) (ch + k);
			} else if (Character.isUpperCase(ch)) {
				if ((ch + k) > 90) {
					offset = (k - (90 - (int) ch) - 1) % 26;
					newStr += (char) ('A' + offset);
				} else
					newStr += (char) (ch + k);
			} else if (Character.isDigit(ch)) {
				if ((ch + k) > 57) {
					offset = (k - (57 - (int) ch) - 1) % 10;
					newStr += (char) ('0' + offset);
				} else
					newStr += (char) (ch + k);
			} else
				newStr += (char) (ch);
		}
		System.out.println(newStr);

	}
}