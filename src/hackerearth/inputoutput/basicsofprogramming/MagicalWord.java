package hackerearth.inputoutput.basicsofprogramming;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MagicalWord {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = in.nextInt();
		int n;
		String word;
		while (t > 0) {
			n = in.nextInt();
			in.nextLine();
			word = in.nextLine();
			w.write(magic(word, n) + "\n");
			t--;
		}
		w.flush();
	}

	public static String magic(String word, int n) {
		String magicWord = "";
		int before, after;
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			char ch = word.charAt(i);
			if (ch < 65) {
				before = after = 65;
			} else if (ch > 90 && ch < 97) {
				if (ch - 90 < 97 - ch)
					before = after = 90;
				else
					before = after = 97;

			} else if (ch > 122) {
				before = after = 122;
			} else { // character lies is an alphabet
				before = ch;
				after = ch;
			}
			while (flag) {
				boolean bflag = checkPrime(before);
				boolean aflag = checkPrime(after);
				if (bflag && aflag && (ch - before) == (ch - after)) {
					magicWord += (char) before;
					flag = false;
				} else if (bflag) {
					magicWord += (char) before;
					flag = false;
				} else if (aflag) {
					magicWord += (char) after;
					flag = false;
				} else {
					if (((char) before == 'A') || ((char) before == 'a')) {
						after++;
					} else if (((char) after == 'Z') || ((char) after == 'z')) {
						before--;
					} else {
						after++;
						before--;
					}

				}
			}
			flag = true;
		}
		return magicWord;
	}

	static boolean checkPrime(long num) {
		double limit = Math.sqrt(num);
		for (long i = 2; i <= limit; i++)
			if (num % i == 0)
				return false;
		return true;
	}
}
