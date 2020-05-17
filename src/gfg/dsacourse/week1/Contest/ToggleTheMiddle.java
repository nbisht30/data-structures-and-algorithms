package gfg.dsacourse.week1.Contest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ToggleTheMiddle {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
		int tests = in.nextInt();
		in.nextLine();
		int n;
		while (tests > 0) {
			n = in.nextInt();
			w.write(toggledNumber(n) + "\n");
			tests--;
		}
		w.flush();
	}

	public static int toggledNumber(int n) {
		int numBits = (int) (Math.log(n) / Math.log(2)) + 1;
		//System.out.println("Number of bits: " + numBits);
		if (numBits % 2 == 0) {
			// toggle two middle bits
			n = n ^ (1 << ((numBits / 2)-1));
			n = n ^ (1 << ((numBits / 2)));
		} else {
			n = n ^ (1 << ((numBits / 2)));
			// toggle the middle bit
		}
		return n;
	}
}
