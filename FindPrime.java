package org.sieveprime.prime;

public class sieveprime {
	public static void main (String args[]){
		FindPrime fp = new FindPrime();
		fp.countPrimes(100);
	}
}



public class FindPrime {
		public int countPrimes(int n) {

		        // initially assume all integers are prime
		        boolean[] isPrime = new boolean[n+1]; //adding 1 for the number 0?
		        //0 and 1 are not counted, not counting towards prime.
		        for (int i = 2; i <= n; i++) {
		            isPrime[i] = true;
		        }

		        // mark non-primes <= N using Sieve of Eratosthenes
		        //not needed to check until n. check until the prime*prime is inside n. 11*11 >100.
		        //So algorithm says after reaching 11 (if n=100), do nothing. all the remaining are primes.
		        for (int i = 2; i*i <= n; i++) {

		            // if i is prime, then mark multiples of i as nonprime
		            // suffices to consider mutiples i, i+1, ..., N/i
		        	//check until 1/3rd for 3 and so on.
		            if (isPrime[i]) {
		                for (int j = i; i*j <= n; j++) {
		                    isPrime[i*j] = false;
		                }
		                System.out.println(i);
		            }
		        }

		        int primes = 0;
		        for (int i = 2; i <= n; i++) {
		            if (isPrime[i]) primes++;
		        }
		        System.out.println("The number of primes <= " + n + " is " + primes);
		    return primes;
		    };
	
		}
