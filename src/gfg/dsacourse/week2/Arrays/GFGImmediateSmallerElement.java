package gfg.dsacourse.week2.Arrays;

import java.util.Scanner;

public class GFGImmediateSmallerElement {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();
		int inArray[][] = new int[tests][500];
		int outArray[][] = new int[tests][500];
		int j = 0;
		int i = 0;
		while (j < tests) {
			int array_size = in.nextInt();
			for (i = 0; i < array_size; i++) {
				inArray[j][i] = in.nextInt();
			}
			for (i = 0; i < array_size-1; i++) {
				if (inArray[j][i] > inArray[j][i + 1])
					outArray[j][i] = inArray[j][i + 1];
				else
					outArray[j][i] = -1;
			}
			outArray[j][i] = -1;
			j++;
		}
		j = 0;
		while (j < tests) {
			for (int k = 0; k<500&&outArray[j][k]!=0; k++) {
				System.out.print(outArray[j][k] + " ");
			}
			System.out.println();
			j++;
		}

	}
}

/*
 * Time complexity: O(3n)-> O(n)
 * */
