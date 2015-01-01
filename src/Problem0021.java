import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solves the problem 21: Amicable numbers.
 */
public class Problem0021 extends AbstractProblem {

    @Override
    public void solve() {
        long total = 0L;
        
        for (long a = 2L; a < 10000L; ++a) {
            final List<Long> divisorsOfA = Utils.getProperDivisors(a);
            long b = 0L;
            
            for (final long e : divisorsOfA) {
                b += e;
            }
            
            final List<Long> divisorsOfB = Utils.getProperDivisors(b);
            
            long sum2 = 0L;
            
            for (final long e : divisorsOfB) {
                sum2 += e;
            }
            
            if (sum2 == a && a != b) {
                total += a + b;
            }
        }
        
        System.out.println(total / 2);
    }
}
