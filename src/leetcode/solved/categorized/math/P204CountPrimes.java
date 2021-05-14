package leetcode.solved.categorized.math;

import java.util.Arrays;

class P204CountPrimes {
    // https://leetcode.com/problems/count-primes/solution/
    /*
    Algorithm : Sieve of Eratosthenes
    Summary:
    1. Create an boolean array of indices from 0 to n, where every index from 1 to n represents an integer.
    2. Initially the array is initialized to true.
    3. Iterate the array and if current index is a prime number, then mark all its multiples as non prime in the remaining array ahead that index, by marking prime[i] = false
    4. At the end count indices where prime[i] = true and return the count.
    */
    public int countPrimes(int n) {

        // 1. Create an boolean array of indices from 0 to n, where every index from 1 to n represents an integer.
        boolean prime[] = new boolean[n + 1];
        // 2. Initially the array is initialized to true.
        Arrays.fill(prime, true);

        // 3. Iterate the array and if current index is a prime number, then mark all its multiples as non prime in the remaining array ahead that index, by marking prime[i] = false


        for (int i = 2; i <= n / i; i++) {
            /*
            Why does the outer loop go till i <= sqrt(n) (same as i <= n / i):-

            We know, n can be represented as sqrt(n) * sqrt (n) => n = sqrt(n) * sqrt(n)
            let m=sqrt(n), so n = m * m
            if n is a composite(non prime) number it can be written as a*b => a*b = m*m
            if a=b then a=b=m, i.e. there is a factor 'm', which is = sqrt(n)
            if a>b then a>m but b<m i.e. there is a factor 'b', which is < sqrt(n)
            if b>a then b>m but a<m i.e. there is again a factor 'a', which is < sqrt(n)
            Hence, there is always a factor of a composite number 'n' that is <=sqrt(n),
            so we don't need to check for i > sqrt(n), as n can be marked as multiple by a prime less that sqrt(n)

            Instead of i <= sqrt(n) we can use i*i <= n. This saves time of calculating sqrt(n)
            also, instead of i * i <= n, we can use i <= n / i to avoid integer overflow of i * i
            */

            if (prime[i]) { // Take current number if it is prime and remove its multiples
				/*
				The question now is why should we start at i*i in below loop.
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
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        // 4. At the end count indices where prime[i] = true and return the count.
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i])
                count++;
        }

        return count;
    }
}