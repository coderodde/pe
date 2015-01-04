/**
 * Solves the problem 27: Quadratic primes.
 */
public class Problem0027 extends AbstractProblem {

    @Override
    public void solve() {
        int besta = Integer.MIN_VALUE;
        int bestb = Integer.MIN_VALUE;
        int longestPrimeSequenceLength = Integer.MIN_VALUE;
        
        for (int a = -999; a < 1000; ++a) {
            for (int b = -999; b < 1000; ++b) {
                int n = 0;
                
                for (; Utils.isPrime(func(n, a, b)); ++n);
                
                if (longestPrimeSequenceLength < n) {
                    longestPrimeSequenceLength = n;
                    besta = a;
                    bestb = b;
                }
            }
        }
        
        System.out.println("a = " + besta + ", b = " + bestb +
                ", ab = " + (besta * bestb));
    }
    
    private int func(final int n, final int a, final int b) {
        return n * n + a * n + b;
    }
}
