package gfg.dsacourse.week1.Recursion;

public class JosephusProblem {
	public static int josephus(int n, int k) {
		if (n == 1)
			return 1;
		return (josephus(n - 1, k) + k - 1) % n + 1;

	}

	public static void main(String[] args) {
		int n = 14;
		int k = 2;
		System.out.println(josephus(n, k));
	}
}
