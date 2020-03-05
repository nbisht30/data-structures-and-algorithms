package gfg.dsacourse.week2.Arrays;

import java.util.Scanner;

public class StocyBuySell {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		int i = 0;
		while (i < N) {
			arr[i] = in.nextInt();
			i++;
		}
		int locMaxima = 0;
		int locMinima = 0;
		int profit = 0;

		i = 0;
		while (i < N - 1) {

			while (i < (N - 1) && arr[i] >= arr[i + 1]) { // till we dont find a greater number
				//i.e till were seeing decreasing prices
				i++;
			}
			//now we have seen an increase in price
			 if (i == N - 1) 
	                break; 
			locMinima = arr[i];
			i++;
			System.out.println("Minima: " + locMinima);
			//look for the point till price keeps increasing
			while (i < (N) && arr[i] >= arr[i - 1]) { // now we keep iterating
				// till we find a smaller number
				i++;
			}
			locMaxima = arr[i-1];
			System.out.println(" Maxima: " + locMaxima);
			profit += locMaxima - locMinima;
		}

//		while (i < N - 1) {
//			if (i == 0 && arr[0] < arr[1]) {
//				locMinima = arr[0];
//				i++;
//				while (i < (N - 1) && !(arr[i - 1] < arr[i] && arr[i] > arr[i + 1])) { // till we dont find a maxima
//					i++;
//				}
//				locMaxima = arr[i];
//				System.out.println("Minima: " + locMinima + " Maxima: " + locMaxima);
//			} else {
//				i++;
//				while (i < (N - 1) && !(arr[i - 1] > arr[i] && arr[i] < arr[i + 1])) {
//					i++;
//				}
//				locMinima = arr[i];
//				while (i < (N - 1) && !(arr[i - 1] < arr[i] && arr[i] > arr[i + 1])) { // till we dont find a maxima
//					i++;
//				}
//				locMaxima = arr[i];
//				System.out.println("Minima: " + locMinima + " Maxima: " + locMaxima);
//			}
//			profit += locMaxima - locMinima;
//		}
		System.out.println("Profit: " + profit);

	}
}
