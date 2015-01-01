
import java.math.BigInteger;

/**
 * Solves the problem 16: Power digit sum.
 */
public class Problem0016 extends AbstractProblem {

    @Override
    public void solve() {
        BigInteger target = BigInteger.valueOf(2).pow(1000);
        char[] chars = target.toString().toCharArray();
        
        int sum = 0;
        
        for (final char c : chars) {
            sum += c - '0';
        }
        
        System.out.println(sum);
    }
}
