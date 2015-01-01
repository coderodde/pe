
import java.util.List;

/**
 * Solves the problem 12: Highly divisible triangular number.
 */
public class Problem0012 extends AbstractProblem {

    @Override
    public void solve() {
        for (long l = 1;; ++l) {
            long test = Utils.arithmeticSum(1L, l);
            if (Utils.getDivisorAmount(test) > 500) {
                System.out.println(test);
                return;
            }
        }
    }
}
