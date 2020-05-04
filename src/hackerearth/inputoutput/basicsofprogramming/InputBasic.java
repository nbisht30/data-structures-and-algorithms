package hackerearth.inputoutput.basicsofprogramming;

import java.util.Scanner;

public class InputBasic {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.nextLine();
		String hello = in.nextLine();
		System.out.println(num * 2);
		System.out.println(hello);
	}
}
