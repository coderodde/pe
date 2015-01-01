
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Solves the problem 10: Summation of primes.
 */
public class Problem0010 extends AbstractProblem {

    private static final long LIMIT = 2000000L;
    
    @Override
    public void solve() {
        long sum = 0L;
        
        for (long prime = 2L; prime < LIMIT; prime = Utils.nextPrime(prime)) {
            sum += prime;
        }
        
        System.out.println(sum);
    }
}
