import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Utils {

    public static List<Long> factorize(long num) {
        final List<Long> factors = new LinkedList<>();
        
        while (num % 2 == 0) {
            num /= 2;
            factors.add(2L);
        }
        
        final long numSqrt = (long) Math.sqrt(num);
        long primeFactor = 3L;
        
        while (primeFactor <= numSqrt) {
            while (num % primeFactor == 0) {
                factors.add(primeFactor);
                num /= primeFactor;
            }
            
            primeFactor = Utils.nextPrime(primeFactor);
        }
        
        return new ArrayList<>(factors);
    }
    
    public static Map<Long, Integer> factorizeAndCompress(long num) {
        final Map<Long, Integer> map = new HashMap<>();
        
        while (num % 2L == 0) {
            num /= 2L;
            
            if (!map.containsKey(2L)) {
                map.put(2L, 1);
            } else {
                map.put(2L, map.get(2L) + 1);
            }
        }
        
        final long numSqrt = (long) Math.sqrt(num);
        long primeFactor = 3L;
        
        while (num > 1L) {
            while (num % primeFactor == 0) {
                if (!map.containsKey(primeFactor)) {
                    map.put(primeFactor, 1);
                } else {
                    map.put(primeFactor, map.get(primeFactor) + 1);
                }
                
                num /= primeFactor;
            }
            
            primeFactor = Utils.nextPrime(primeFactor);
        }
        
        return map;
    }
    
    /**
     * Checks whether the input long integer is a prime.
     *
     * @param candidate the candidate for primality test.
     *
     * @return <code>true</code> if <code>candidate</code> is a prime,
     * <code>false</code> otherwise.
     */
    public static boolean isPrime(final long candidate) {
        if (candidate < 2L) {
            return false;
        }

        if (candidate % 2 == 0 && candidate != 2L) {
            return false;
        }
        
        final long candidateSqrt = (long) Math.sqrt(candidate);

        for (long f = 3L; f <= candidateSqrt; f += 2L) {
            if (candidate % f == 0L) {
                return false;
            }
        }

        return true;
    }


    /**
     * Returns the next prime assuming that <code>fromPrime</code> is a prime
     * and is at least 3.
     *
     * @param fromPrime the starting prime.
     *
     * @return the next prime larger than <code>fromPrime</code>.
     */
    public static long nextPrime(final long fromPrime) {
        if (fromPrime < 2L) {
            return 2L;
        }
        
        if (fromPrime == 2L) {
            return 3L;
        }
        
        if (isPrime(fromPrime)) {
            long candidate = fromPrime + 2L;
            
            for (;; candidate += 2L) {
                if (isPrime(candidate)) {
                    return candidate;
                }
            }
        } else {
            long candidate = fromPrime | 1L;
            
            for (;; candidate += 2L) {
                if (isPrime(candidate)) {
                    return candidate;
                }
            }
        }
    }
        
    /**
     * Checks whether the given number is palindromic, that is, it reads the 
     * same both ways.
     * 
     * @param number the number to check.
     * @return <code>true</code> if <code>number</code> is palindromic,
     *         <code>false</code> otherwise.
     */
    public static boolean isPalindromicNumber(final long number) {
        final char[] chars = Long.toString(number).toCharArray();
        
        for (int i = 0, j = chars.length - 1; i < j; ++i, --j) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static long arithmeticSum(final long from, final long to) {
        return (from + to) * (to - from + 1) / 2;
    }
    
    public static long squareSum(final long from, final long to) {
        return squareSum(to) - squareSum(from - 1);
    }
    
    public static long squareSum(final long n) {
        return n * (n + 1) * (2 * n + 1) / 6;
    }
    
    public static boolean isPythagoreanTriplet(final long a,
                                               final long b,
                                               final long c) {
        return a * a + b * b == c * c;
    }

    public static Long getDivisorAmount(final long num) {
        final Map<Long, Integer> map = Utils.factorizeAndCompress(num);
        long product = 1L;
        
        for (final Integer i : map.values()) {
            product *= (i + 1);
        }
        
        return product;
    }
    
    public static BigInteger bigBinomial(final long n, final long k) {
        BigInteger result = BigInteger.ONE;
        
        if (k == 0L || k == n) {
            return result;
        }
        
        for (long l = n; l > k; --l) {
            result = result.multiply(BigInteger.valueOf(l));
        }
        
        for (long l = 2L; l <= k; ++l) {
            result = result.divide(BigInteger.valueOf(l));
        }
        
        return result;
    }
    
    public static long binomial(final long n, final long k) {
        if (k == 0L || k == n) {
            return 1L;
        }
        
        long result = 1L;
        
        for (long i = n; i > k; --i) {
            result *= i;
        }
        
        for (long i = 2; i <= k; ++i) {
            result /= i;
        }
        
        return result;
    }
    
    /**
     * Computes <code>n * (n - 1) * ... * (k + 1) * k</code>.
     * @param n the size of the set.
     * @param k the size of the subset to choose.
     * @return as above.
     */
    public static long generalFactorial(final long n, final long k) {
        if (k == 0L) {
            return 1L;
        }
        
        long result = k;
        
        for (long i = k + 1; i <= n; ++i) {
            result *= i;
        }
        
        return result;
    }
    
    public static long factorial(final long n) {
        if (n <= 0L) {
            return 1L;
        }
        
        long result = 1L;
        
        for (long k = 2L; k <= n; ++k) {
            result *= k;
        }
        
        return result;
    }
    
    public static long collatzSequenceLenght(long num) {
        long count = 1L;
        for (; num != 1L; ++count, num = collatz(num));
        return count;
    }
    
    public static long collatz(final long num) {
        return ((num & 1) == 0) ? num >>> 1 : 3 * num + 1;
    }
}
