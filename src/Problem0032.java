import java.util.HashSet;
import java.util.Set;

/**
 * Solves the problem 32: Pandigital products.
 */
public class Problem0032 extends AbstractProblem {

    private static final long N = 5000L;
    private final boolean[] map = new boolean[10];
    
    @Override
    public void solve() {
        final Set<Integer> set = new HashSet<>();
        
        for (int a = 1; a < N; ++a) {
            for (int b = 1; b < N; ++b) {
                final int product = a * b;
                
                if (isPandigital(a, b, product)) {
                    set.add(product);         
                }
            }
        }
        
        int sum = 0;
        
        for (final int i : set) {
            sum += i;
        }
        
        System.out.println(sum);
    }
    
    private boolean isPandigital(final int a, final int b, final int product) {
        final String stra = Long.toString(a);
        final String strb = Long.toString(b);
        final String strProduct = Long.toString(product);
        
        final int len = stra.length() + strb.length() + strProduct.length();
        
        if (len > 9) {
            return false;
        }
        
        for (int i = 1; i < map.length; ++i) {
            map[i] = false;
        }
        
        for (final char c : stra.toCharArray()) {
            map[c - '0'] = true;
        }
        
        for (final char c : strb.toCharArray()) {
            map[c - '0'] = true;
        }
        
        for (final char c : strProduct.toCharArray()) {
            map[c - '0'] = true;
        }
        
        for (int i = 1; i <= 9; ++i) {
            if (!map[i]) {
                return false;
            }
        }
        
        return true;
    }
}
