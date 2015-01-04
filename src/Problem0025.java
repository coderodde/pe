
import java.math.BigInteger;

/**
 * Solves the problem 25: 1000-digit Fibonacci number.
 */
public class Problem0025 extends AbstractProblem {

    @Override
    public void solve() {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        int term = 2;
        
        while (b.toString().length() < 1000) {
            BigInteger tmp = a;
            a = b;
            b = tmp.add(b);
            ++term;
        }
        
        System.out.println(term);
    }
}
