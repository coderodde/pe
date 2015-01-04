
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Solves the problem 29: Distinct powers.
 */
public class Problem0029 extends AbstractProblem {

    @Override
    public void solve() {
        final Set<BigInteger> set = new HashSet<>();
        
        for (int a = 2; a <= 100; ++a) {
            final BigInteger biga = BigInteger.valueOf(a);
            
            for (int b = 2; b <= 100; ++b) {
                set.add(biga.pow(b));
            }
        }
        
        System.out.println(set.size());
    }
}
