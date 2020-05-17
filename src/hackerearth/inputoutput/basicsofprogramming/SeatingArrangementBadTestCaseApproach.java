package hackerearth.inputoutput.basicsofprogramming;

import java.util.Scanner;

/*
 * This program keeps two loops -> one for input of test cases and 
 * other for execution for those test cases.
 * This is a bad approach. Use BufferedWriter instead, see SeatingArrangement
 * */
public class SeatingArrangementBadTestCaseApproach {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int T, ch;
		T = in.nextInt();
		int[] N = new int[T];
		for (int i = 0; i < T; i++)
			N[i] = in.nextInt();
		int i = 0;
		while (T > 0) {
			ch = N[i] % 12;
			switch (ch) {
			case 0:
				System.out.println((N[i] - 11) + " WS");
				break;
			case 1:
				System.out.println((N[i] + 11) + " WS");
				break;
			case 2:
				System.out.println((N[i] + 9) + " MS");
				break;
			case 3:
				System.out.println((N[i] + 7) + " AS");
				break;
			case 4:
				System.out.println((N[i] + 5) + " AS");
				break;
			case 5:
				System.out.println((N[i] + 3) + " MS");
				break;
			case 6:
				System.out.println((N[i] + 1) + " WS");
				break;
			case 7:
				System.out.println((N[i] - 1) + " WS");
				break;
			case 8:
				System.out.println((N[i] - 3) + " MS");
				break;
			case 9:
				System.out.println((N[i] - 5) + " AS");
				break;
			case 10:
				System.out.println((N[i] - 7) + " AS");
				break;
			case 11:
				System.out.println((N[i] - 9) + " MS");
				break;
			}
			i++;
			T--;
		}
	}
}
