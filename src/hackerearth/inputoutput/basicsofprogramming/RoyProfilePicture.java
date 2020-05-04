package hackerearth.inputoutput.basicsofprogramming;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class RoyProfilePicture {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
		int L = in.nextInt();
		int N = in.nextInt();
		int W, H;
		while (N > 0) {
			W = in.nextInt();
			H = in.nextInt();
			w.write(photo(W, H, L) + "\n");
			N--;
		}
		w.flush();
	}

	public static String photo(int w, int h, int l) {
		if (w == h && w >= l)
			return "ACCEPTED";
		else {
			if (w > l && h > l)
				return "CROP IT";
			else if (w == l && h > l)
				return "CROP IT";
			else if (w < l && h > l)
				return "UPLOAD ANOTHER";
			else if (w > l && h == l)
				return "CROP IT";
			else
				return "UPLOAD ANOTHER";
		}

	}
}
