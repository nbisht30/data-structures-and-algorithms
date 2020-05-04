package hackerearth.inputoutput.basicsofprogramming;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SeatingArrangement {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
		// For doing everything in one loop
		// other wise you have one loop for the input of test cases and other loop
		// executing for those test cases and printing out the result for each test case

		int T, ch;
		T = in.nextInt();
		int[] N = new int[T];
		for (int i = 0; i < T; i++) {
			N[i] = in.nextInt();

			ch = N[i] % 12;
			switch (ch) {
			case 0:
				w.write((N[i] - 11) + " WS\n");
				break;
			case 1:
				w.write((N[i] + 11) + " WS\n");
				break;
			case 2:
				w.write((N[i] + 9) + " MS\n");
				break;
			case 3:
				w.write((N[i] + 7) + " AS\n");
				break;
			case 4:
				w.write((N[i] + 5) + " AS\n");
				break;
			case 5:
				w.write((N[i] + 3) + " MS\n");
				break;
			case 6:
				w.write((N[i] + 1) + " WS\n");
				break;
			case 7:
				w.write((N[i] - 1) + " WS\n");
				break;
			case 8:
				w.write((N[i] - 3) + " MS\n");
				break;
			case 9:
				w.write((N[i] - 5) + " AS\n");
				break;
			case 10:
				w.write((N[i] - 7) + " AS\n");
				break;
			case 11:
				w.write((N[i] - 9) + " MS\n");
				break;
			}

		}
		w.flush();

	}

}
