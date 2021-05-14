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
			// We know that, n can be represented as sqrt(n) * sqrt (n) => n = sqrt(n) * sqrt(n)
			// let m=sqrt(n), so n = m * m
			// if n is a composite(non prime) number it can be written as a*b
			// a*b=m*m
			// if a=b then a=b=m, i.e. there is a factor 'm', which is = sqrt(n)
			// if a>b then a>m but b<m i.e. there is a factor 'b', which is < sqrt(n)
			// if b>a then b>m but a<m i.e. there is again a factor 'a', which is < sqrt(n)
			// Hence, there is always a factor of a composite number 'n' that is <=sqrt(n)
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

		// Why check till sqrt:-
		// We know that, n can be represented as sqrt(n) * sqrt (n) => n = sqrt(n) * sqrt(n)
		// let m=sqrt(n), so n = m * m
		// if n is a composite(non prime) number it can be written as a*b
		// a*b=m*m
		// if a=b then a=b=m, i.e. there is a factor 'm', which is = sqrt(n)
		// if a>b then a>m but b<m i.e. there is a factor 'b', which is < sqrt(n)
		// if b>a then b>m but a<m i.e. there is again a factor 'a', which is < sqrt(n)
		// Hence, there is always a factor of a composite number 'n' that is <=sqrt(n)

		for (int p = 2; p * p <= n; p++) {
			// instead of p<=sqrt(n) we can use p*p<=n. This saves time of calculating sqrt()
			// also, instead of p * p <= n, we can use p <= n / p to avoid integer overflow of p * p
			if (prime[p]) {
				/*
				The question now is why should we start at i*i.
				Why not start at 2*i to keep things simple?
				The reason is that all of the previous multiples would already have been covered by previous primes.
				In number theory, the fundamental theorem of arithmetic, also called the unique factorization theorem
				or the unique prime factorization theorem, states that every integer greater than 1 either is a prime number
				itself or can be represented as the product of prime numbers.
				So the prime numbers smaller than i would have already covered the multiples smaller than i*i.
				Let's look at the prime number 7 to see how all the multiples up to 7*7 are already covered by primes smaller than '7'.
				Let's assume that n is 50 (a value greater than 7*7) to demonstrate this claim.

				7 * 2 = 14 = 2 * 7
				7 * 3 = 21 = 3 * 7
				7 * 4 = 28 = 2 * 2 * 7 = 2 * 14
				7 * 5 = 35 = 5 * 7
				7 * 6 = 42 = 2 * 3 * 7 = 2 * 21
				 */
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
		 * work by repeatedly crossing off composite numbers. There are relatively few primes,
		 * but many composites, so one might be tempted to think trial division wastes
		 * less work. But: Composites have only few distinct prime factors, while there
		 * are many primes below sqrt(p).
		 */
	}

}
