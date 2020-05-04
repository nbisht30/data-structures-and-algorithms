package hackerearth.inputoutput.basicsofprogramming;

import java.util.Scanner;

public class PrimeNumbersTillN {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long before, after;
		int num = in.nextInt();
		before = System.nanoTime();
		sieveOfEratosthenes(num);
		after = System.nanoTime();
		System.out.println("Sieve primality: " + (after - before) / 1000 + " microsecs");
		System.out.println();
		before = System.nanoTime();
		primeBasic(num);
		after = System.nanoTime();
		System.out.println("Basic primality: " + (after - before) / 1000 + " microsecs");
	}

	public static void primeBasic(int n) { // KNOWN AS THE SCHOOL METHOD
		int counter = 0;
		int sqrt;
		for (int i = 2; i <= n; i++) {
			sqrt = (int) Math.sqrt(i);
			// Why check till sqrt:-
			// let m=sqrt(n)
			// n can be represented as sqrt(n) * sqrt (n) i.e. m*m
			// if n is a composite number it can be written as a*b
			// a*b=m*m
			// if a=b then a=b=m
			// if a>b then a>m but b<m i.e. there is a factor less than sqrt(n)
			// if b>a then b>m but a<m i.e. there is again a factor less than sqrt(n)
			// hence => there is always a factor of n that is <=sqrt(n)
			for (int j = 2; j <= sqrt; j++) {
				if (i % j == 0)
					counter++;
				if (counter == 1) {
					break;
				}
			}
			if (counter == 0) {
				System.out.print(i + " ");
			}
			counter = 0;
		}
		/*
		 * In the trial division algorithm, the most work that may be needed to
		 * determine whether a number n is prime, is testing if its divisible by the primes
		 * up to about sqrt(n)
		 */
	}

	public static void sieveOfEratosthenes(int n) { // Complexity : O(n*log(log(n)))
		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			prime[i] = true; // initially assuming all numbers to be prime
		}
		for (int p = 2; p * p <= n; p++) { // instead of p<=sqrt(n) we can use p*p<=n.
			// This saves time of sqrt()
			if (prime[p]) {
				for (int i = p * p; i <= n; i += p) {
					prime[i] = false;
				}
			}
		}
		// Printing out all primes till n
		for (int i = 2; i <= n; i++) {
			if (prime[i])
				System.out.print(i + " ");
		}
		/*
		 * Trial division does futile work by dividing primes, the sieve does futile
		 * work by repeatedly crossing off composites. There are relatively few primes,
		 * but many composites, so one might be tempted to think trial division wastes
		 * less work. But: Composites have only few distinct prime factors, while there
		 * are many primes below sqrt(p).
		 */
	}

}
