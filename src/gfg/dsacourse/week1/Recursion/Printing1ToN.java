package gfg.dsacourse.week1.Recursion;

public class Printing1ToN {

	public static void printNTo1(int n) {
		if (n == 0) {
			return ;
		}
		System.out.println(n);
		 printNTo1(n - 1);

	}

	public static void print1ToN(int n) {
		if (n == 0) {
			return ;
		}
		print1ToN(n-1);
		System.out.println(n);
	}
	
	public static void main(String[] args) {
		printNTo1(10);
	}
}
