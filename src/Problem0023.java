/**
 * Solves the problem 23: Non-abundant sums.
 */
public class Problem0023 extends AbstractProblem {

    private static final long LIMIT = 28123L;
    
    @Override
    public void solve() {
        long sum = 0L;
        
        boolean[] isAbundant = new boolean[(int)(LIMIT + 1)];
        
        for (int i = 1; i <= LIMIT; ++i) {
            isAbundant[i] = Utils.isAbundantNumber(i);
        }
        
        outer:
        for (int l = 1; l <= (int) LIMIT; ++l) {
            for (int a = 1; a < l / 2 + 1; ++a) {
                if (isAbundant[a] && isAbundant[l - a]) {
                    // Try next one.
                    continue outer;
                }
            }
            
            sum += l;
        }
        
        System.out.println(sum);
    }
}
