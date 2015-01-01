
import java.math.BigInteger;

/**
 * Solving the problem 20: Factorial digit sum.
 */
public class Problem0020 extends AbstractProblem {

    @Override
    public void solve() {
        final BigInteger f = Utils.bigFactorial(100L);
        final char[] chars = f.toString().toCharArray();
        int digitSum = 0;
        
        for (final char c : chars) {
            digitSum += c - '0';
        }
        
        System.out.println(digitSum);
    }
}
