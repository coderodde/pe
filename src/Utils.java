import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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

    public static long previousPrime(long fromPrime) {
        if (fromPrime <= 2L) {
            return Long.MIN_VALUE;
        }
        
        if (fromPrime == 3L) {
            return 2L;
        }
        
        if ((fromPrime & 1) == 0) {
            // Is even.
            fromPrime--;
        } else {
            fromPrime -= 2;
        }
        
        while (!isPrime(fromPrime)) {
            fromPrime -= 2;
        }
        
        return fromPrime;
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
    
    public static List<Long> getDivisors(final long num) {
        final List<Long> divisors = new ArrayList<>();
        
        for (long l = 1L; l <= num; ++l) {
            if (num % l == 0L) {
                divisors.add(l);
            }
        }
        
        return divisors;
    }
    
    public static List<Long> getProperDivisors(final long num) {
        final List<Long> divisors = getDivisors(num);
        divisors.remove(divisors.size() - 1);
        return divisors;
    }
    
    public static BigInteger bigFactorial(final long n) {
        BigInteger f = BigInteger.ONE;
        
        for (long l = 2L; l <= n; ++l) {
            f = f.multiply(BigInteger.valueOf(l));
        }
        
        return f;
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
    
    public static boolean isAbundantNumber(final long num) {
        final List<Long> divisors = getProperDivisors(num);
        long sum = 0L;
        
        for (final long divisor : divisors) {
            sum += divisor;
        }
        
        return sum > num;
    }
 
    public static <E extends Comparable<E>> boolean permute(final E[] array){
        int i = array.length - 2;
        
        while (i >= 0 && array[i].compareTo(array[i + 1]) > 0) {
            --i;
        }
        
        if (i == -1) {
            // The input array contains the last lexicographic permutation;
            // return false.
            return false;
        }
        
        final E lowerBound = array[i];
        int minIndex = i + 1;
        E min = array[minIndex];
        
        for (int j = minIndex + 1; j < array.length; ++j) {
            if (min.compareTo(array[j]) > 0 && array[j].compareTo(lowerBound) > 0) {
                min = array[j];
                minIndex = j;
            }
        }
        
        E tmp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = tmp;
        
        for (int l = i + 1, r = array.length - 1; l < r; l++, r--) {
            tmp = array[l];
            array[l] = array[r];
            array[r] = tmp;
        }
        
        return true;
    }
 
    public static <E extends Comparable<E>> boolean permuteBack(final E[] array){
        int i = array.length - 2;
        
        while (i >= 0 && array[i].compareTo(array[i + 1]) < 0) {
            --i;
        }
        
        if (i == -1) {
            // The input array contains the last lexicographic permutation;
            // return false.
            return false;
        }
        
        final E upperBound = array[i];
        int maxIndex = i + 1;
        E max = array[maxIndex];
        
        for (int j = maxIndex + 1; j < array.length; ++j) {
            if (max.compareTo(array[j]) < 0 && array[j].compareTo(upperBound) < 0) {
                max = array[j];
                maxIndex = j;
            }
        }
        
        E tmp = array[i];
        array[i] = array[maxIndex];
        array[maxIndex] = tmp;
        
        for (int l = i + 1, r = array.length - 1; l < r; l++, r--) {
            tmp = array[l];
            array[l] = array[r];
            array[r] = tmp;
        }
        
        return true;
    }
    
    public static void print(final Object[] array) {
        for (final Object o : array) {
            System.out.print(o.toString() + " ");
        }
        
        System.out.println();
    }
    
    public static final <E> boolean 
        listsHaveSameContent(final List<E> list1, 
                             final List<E> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); ++i) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }

        return true;
    }
        
    public static int[] toDigit(final long num) {
        final char[] chars = Long.toString(num).toCharArray();
        final int[] result = new int[chars.length];
        
        for (int i = 0; i < chars.length; ++i) {
            result[i] = chars[i] - '0';
        }
        
        return result;
    }
    
    public static int[] getAllRotations(final int num) {
        final char[] chars = Integer.toString(num).toCharArray();
        final int[] ret = new int[chars.length];
        
        final Queue<Character> queue = new ArrayDeque<>();
        
        for (final char c : chars) {
            queue.add(c);
        }
        
        final StringBuilder sb = new StringBuilder(chars.length);
        
        for (int i = 0; i < chars.length; ++i) {
            // Clear the string builder.
            sb.delete(0, sb.length());
            
            for (final Character c : queue) {
                sb.append(c);
            }
            
            try {
                ret[i] = Integer.parseInt(sb.toString());
            } catch (final NumberFormatException nfe) {
                
            }
            
            queue.add(queue.remove());
        }
        
        return ret;
    }
    
    public static <E> boolean isPalindromicArray(final char[] array) {
        for (int l = 0, r = array.length - 1; l < r; ++l, --r) {
            if (array[l] != array[r]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isPandigital(final long num) {
        final char[] chars = Long.toString(num).toCharArray();
        
        if (chars.length > 9) {
            return false;
        }
        
        boolean[] map = new boolean[10];
        int n = 0;
        
        for (final char c : chars) {
            if (!map[c - '0']) {
                map[c - '0'] = true;
                ++n;
            }
        }
        
        for (int i = 1; i <= n; ++i) {
            if (!map[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static long buildLongFromDigits(final Integer[] array) {
        long l = 0L;
        reverse(array);
        for (int i = 0, m = 1; i < array.length; ++i, m *= 10) {
            l += array[i] * m;
        }
        reverse(array);
        return l;
    }
    
    public static <E> void reverse(final E[] array) {
        for (int l = 0, r = array.length - 1; l < r; l++, r--) {
            final E tmp = array[l];
            array[l] = array[r];
            array[r] = tmp;
        }
    }
    
    public static int getWordCode(final String word) {
        int sum = 0;
        
        for (final char c : word.toUpperCase().toCharArray()) {
            sum += c - 'A' + 1;
        }
        
        return sum;
    }
    
    public static boolean isTriangleNumber(int num) {
        num *= 2;
        
        for (int n = 0; ; ++n) {
            final int current = n * (n + 1);
            
            if (current > num) {
                return false;
            } else if (current == num) {
                return true;
            }
        }
    }
}
