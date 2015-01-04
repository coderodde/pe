
import java.util.HashSet;
import java.util.Set;

/**
 * Solves the problem 35: Circular primes.
 */
public class Problem0035 extends AbstractProblem {

    @Override
    public void solve() {
        final Set<Integer> set = new HashSet<>();
        
        outer:
        for (int num = 2; num < 1000000; num = (int) Utils.nextPrime(num)) {
            final int[] rotations = Utils.getAllRotations(num);
            
            for (final int rotation : rotations) {
                if (!Utils.isPrime(rotation)) {
                    continue outer;
                }
            }
            
            set.add(num);
        }
        
        System.out.println(set.size());
    }
}
