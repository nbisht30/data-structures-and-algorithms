package gfg.dsacourse.week1.Recursion;

public class Subsequences {
	public static void subseq(String str, String currStr, int i, String target) {
		if (i == str.length()) {
			 if(currStr.equals(target))
			System.out.println(currStr);
			return;
		}
		subseq(str, currStr, i + 1, target); // skip value at i
		subseq(str, currStr + str.charAt(i), i + 1, target);
	}

	public static void main(String[] args) {
		subseq("ABCAB", "", 0, "AB");
	}
}
