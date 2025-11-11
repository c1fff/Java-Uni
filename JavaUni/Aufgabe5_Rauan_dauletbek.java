//Rauan Dauletbek, 12337766
package einfprog;

public class Bsp05 {
    public static void main(String[] args) {
        System.out.println("Alle Primazahlen <= n");
        System.out.println("?n: ");
        int n = SavitchIn.readLineInt();

        boolean[] primes = firstPrimes(n);
        int count = printFirstPrimes(primes);
        System.out.println("Insgesamt: "+count+" Primazahlen <= " + n);
        
        System.out.print("?Iterationen: ");
        int iterations = SavitchIn.readLineInt();

        System.out.println("Zahl -> nächstliegende Primzahl");

        for (int i = 0; i < iterations; i++) {
            PRNG prng = new PRNG();
            int randomNumber = prng.randomInt(n)+1;
            int closest = closestPrime(primes, randomNumber);
            System.out.println(randomNumber + " -> " + closest);
        }
    }

    /**
     * Checks whether a number is prime.
     *
     * @return true if n is positive and prime, false otherwise.
     */
    public static boolean isPrime(int n) {
    if (n <= 1) {
        return false;
    }
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}

    /**
     * Checks which natural numbers from 0 to n are primes
     *
     * @param n maximum number to check
     * @return array with n+1 elements with value true at index i if i is a prime
     *  and false otherwise
     */
    public static boolean[] firstPrimes(int n) {
    boolean[] primes = new boolean[n + 1];
    for (int i = 0; i <= n; i++) {
        primes[i] = isPrime(i);
    }
    return primes;
}

    /**
     * Prints prime numbers
     *
     * @param firstPrimes array indicating which numbers are prime
     * @return number of primes in the array
     */
    public static int printFirstPrimes(boolean[] firstPrimes) {
    int count = 0;
    for (int i = 0; i < firstPrimes.length; i++) {
        if (firstPrimes[i]) {
            System.out.print(i + " ");
            count++;
        }
    }
    System.out.println();
    return count;
}

    /**
     * Finds the prime number closest to m.
     *
     * That is, the smallest prime number bigger than m or the biggest
     * prime number smaller than m, whichever is closest to m. If both
     * are equally distanced from m, return the *smaller* value.
     *
     * @param firstPrimes array indicating which numbers are prime and which not
     * @param m index into array
     * @return as above, or -1 if m is not an index in firstPrimes or there's no prime there
     */
    public static int closestPrime(boolean[] firstPrimes, int m) {
    if (m >= 0 && m < firstPrimes.length && firstPrimes[m]) {
        return m;
    }

    int lower = -1;
    int higher = -1;

    int start = Math.max(0, -m); // Начало поиска для отрицательных чисел

    for (int i = start; i < firstPrimes.length + m; i++) {
        if (i < firstPrimes.length && firstPrimes[i]) {
            higher = i;
            break;
        }
    }

    for (int i = start; i >= 0; i--) {
        if (firstPrimes[i]) {
            lower = i;
            break;
        }
    }

    if (lower == -1 && higher == -1) {
        return -1;
    } else if (lower == -1) {
        return higher;
    } else if (higher == -1) {
        return lower;
    } else {
        return Math.abs(m - lower) <= Math.abs(higher - m) ? lower : higher;
    }
}
}