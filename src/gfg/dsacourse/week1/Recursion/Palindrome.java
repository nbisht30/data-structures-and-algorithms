package gfg.dsacourse.week1.Recursion;

public class Palindrome {
	public static boolean isPalin(String args, int s, int e) {
		if (s >= e) {
			return true;
		}
		if (args.charAt(s) == args.charAt(e)) {
			return isPalin(args, s + 1, e - 1);
		} else
			return false;
	}

	public static void main(String[] args) {
		String str = "mainiam";
		int s = 0, e = str.length() - 1;
		if (isPalin(str, s, e))
			System.out.println("Palindrome.");
		else
			System.out.println("Not Palindrome.");
	}
}
