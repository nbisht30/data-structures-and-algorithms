package hackerearth.inputoutput.basicsofprogramming;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SoftSort {
	static long M[] = new long[1000001];

	public static void main(String[] args) throws IOException {

		M[0] = M[1] = 1;
		Scanner in = new Scanner(System.in);
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = in.nextInt();
		int n;
		long mod;
		while (t > 0) {
			n = in.nextInt();
			M[n] = facto(n);
			mod = (M[n] + (M[n] - 1) * 2 + 5) % 1000000007;
			w.write(mod + "\n");
			t--;
		}
		w.flush();

	}

	// WORKING METHOD
//	public static long facto(int n) {
//		if (M[n] >= 1) // USING THE CONCEPT OF MEMOIZATION
//			return M[n];
//		else {
//			long result = 1;
//			for (int i = n; i > 1; i--) {
//				if (M[i - 1] >= 1) {
//					M[i] = (i * M[i - 1]) % (1000000007);
//					result = (result * M[i]) % (1000000007);
//					break;
//				}
//				result = (result * i) % 1000000007;
//
//			}
//			return result;
//		}
//	}
	
	// WHY DOES THIS NOT WORK
			public static long facto(int n) {
				if (M[n] >= 1) // USING THE CONCEPT OF MEMOIZATION
					return M[n];
				else {
					long result = 1;
					for (int i = n; i > 1; i--) {
						if (M[i - 1] >= 1) {
							//M[i] = (i * M[i - 1]) % (1000000007);
							result = (result * i * M[i-1]) % (1000000007);
							break;
						}
						result = (result * i) % 1000000007;

					}
					return result;
				}
			}

	// FIGURE OUT THE PROBLEM WITH THIS METHOD
	// Agar do number hai 12 and 13 aur 12 ka phle hi factorial nikal gya hai
	// to 13 ka nikalte time
	// M[i] = (i * M[i - 1]) % (1000000007); ->M[13] = 13 * M[12] ->this is fine
	//M[n] = (M[n] * M[i]) % (1000000007); - > But yaha pe is value ka square ho jayega
//		public static long facto(int n) {
//			if (M[n] >= 1)
//				return M[n];
//			else {
//				M[n] = 1;
//				for (int i = n; i > 1; i--) {
//					if (M[i - 1] >= 1) {
//						M[i] = (i * M[i - 1]) % (1000000007);
//						M[n] = (M[n] * M[i]) % (1000000007);
//						break;
//					}
//					M[n] = (M[n] * i) % 1000000007;
//				}
//				return M[n];
//			}
//		}

// THIS ONE WAS SLOW: WHY?? BECAUSE IT WOULD FIND FACTORIALS AGAIN, WOULD
// NOT STOP WHEN THERE IS ALREADY A FACTOR
//	public static long facto(int n) {
//		if (n == 1)
//			return 1;
//		if (M[n] > 1) 
//			return M[n];
//		else {
//			M[n] = 1;
//			for (int i = n; i > 1; i--) {
//				M[n] = (M[n] * i) % 1000000007;
//			}
//			return M[n];
//		}
//	}

	

}
