package gfg.dsacourse.week1.BitMagic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SwapAllOddAndEvenBits {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;
		int t = in.nextInt();
		in.nextLine();
		while (t > 0) {
			N = in.nextInt();
			w.write(swapBits(N) + "\n");
			t--;
		}
		w.flush();
	}

	public static int swapBits(int N) {
		int i = 0;
		int ret = N;
		int numOfBits = (int) (Math.log(N) / Math.log(2)) + 1;
		while (i < numOfBits) {
			if (isSet(N, i) && !isSet(N, i + 1)) { // ie. [0,1] -> [(i+1)th term, ith term]
				ret = ret | 1 << (i + 1); // set the (i+1)th bit
				ret = ret & ~(1 << (i)); // reset the ith bit
			} else if (!isSet(N, i) && isSet(N, i + 1)) { // ie. [1,0] -> [(i+1)th term, ith term]
				ret = ret | 1 << i; // set the ith bit
				ret = ret & ~(1 << (i + 1)); // reset the (i+1)th bit
			}
			i = i + 2;
		}
		return ret;
	} 

	public static boolean isSet(int n, int i) {
		if ((n & (1 << i)) > 0)
			return true;
		else
			return false;
	}
}
