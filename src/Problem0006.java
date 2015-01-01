/**
 * Solves the problem 6: Sum square difference.
 */
public class Problem0006 extends AbstractProblem {

    private static final long LIMIT = 100L;
    
    @Override
    public void solve() {
        final long sum1 = Utils.arithmeticSum(1L, LIMIT);
        final long sum1Squared = sum1 * sum1;
        final long sum2 = Utils.squareSum(LIMIT);
        System.out.println(sum1Squared - sum2);
    }
}
