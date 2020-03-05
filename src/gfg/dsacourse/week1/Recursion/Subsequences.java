package gfg.dsacourse.week1.Recursion;

public class Subsequences {
	public static void subseq(String str, String currStr, int i) {
		if (i == str.length()) {
			System.out.println(currStr);
			return;
		}
		subseq(str, currStr, i + 1); // skip value at i
		subseq(str, currStr + str.charAt(i), i + 1);
	}

	public static void main(String[] args) {
		subseq("ABC", "", 0);
	}
}
