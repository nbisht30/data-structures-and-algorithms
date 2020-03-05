package gfg.dsacourse.InterviewQues;

/*
 * Maximum 0�s between two immediate 1�s in binary representation | Tags : Bit Magic
 * Company : Naggaro
 * URL : https://www.geeksforgeeks.org/maximum-0s-two-immediate-1s-binary-representation/
*/
public class BitMagic1 {
	public static void main(String args[]) {
		int n = 8;
//		int bin = findBinary(n);
//		System.out.println(bin);
		String binary = Integer.toBinaryString(n);
		System.out.println(binary);
		findZerosBasic(binary);
		
	}

	public static int findBinary(int n) {
		// method to convert to binary OR javaPredefinedMethod can be used
		int r = 0, p = 1;
		int binary = 0;
		while (n >= 1) {
			r = n % 2;
			n = n / 2;
			binary = binary + (r * p);
			p = p * 10;
		}
		return binary;
	}
	public static void findZerosBasic(String binary) {
		int len = binary.length();
		int prevC = 0, count = 0;
		for (int i = 0; i < len - 1; i++) {
			if (binary.charAt(i) == '0') {
				count++;
			}
			if (binary.charAt(i) == '1' && binary.charAt(i + 1) == '0') {

				if (prevC < count) {
					prevC = count;
				}
				count = 0;
			}
			if (binary.charAt(i) == '1' && binary.charAt(i + 1) == '1') {

			}
		}
		System.out.println(prevC);

	}
}
