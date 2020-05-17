package gfg.dsacourse.week1.Contest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TheConversionToOne {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
		int tests = in.nextInt();
		in.nextLine();
		int n[] = new int[2];
		while (tests > 0) {
			n[0] = in.nextInt();
			w.write(steps(n) + "\n");
			tests--;
		}
		w.flush();
	}

	public static int[] steps(int n[]) {
		if (n[0] == 1) {
			return n;
		}
		if (n[0] % 2 == 0) {
			n[1]++;
			return steps(n);
		} else {
			n[0]--;
			return steps(n); 
		}
		

	}

}
