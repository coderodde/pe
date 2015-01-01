/**
 * Solves the problem 3: Largest prime factor.
 */
public class Problem0003 extends AbstractProblem {

    private static final long TARGET_NUMBER = 600851475143L;

    @Override
    public void solve() {
        final long TARGET_NUMBER_SQRT = (long) Math.sqrt(TARGET_NUMBER);
        
        for (long factor = TARGET_NUMBER_SQRT; factor > 1L; --factor) {
            if (Utils.isPrime(factor) && (TARGET_NUMBER % factor == 0L)) {
                System.out.println(factor);
                break;
            }
        }
    }
}
