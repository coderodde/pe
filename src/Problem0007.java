/**
 * Solves the problem: 10001st prime.
 */
public class Problem0007 extends AbstractProblem {

    private static final int TARGET_PRIME_INDEX = 10001;
    
    @Override
    public void solve() {
        int i = 1;
        long currentPrime = 2L;
        
        for (; i < TARGET_PRIME_INDEX; ++i) {
            currentPrime = Utils.nextPrime(currentPrime);
        }
        
        System.out.println(currentPrime);
    }
}
