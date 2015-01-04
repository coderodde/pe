
import java.util.HashMap;
import java.util.Map;

/**
 * Solves the problem 39: Integer right triangles.
 */
public class Problem0039 extends AbstractProblem {

    @Override
    public void solve() {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int p = 12; p <= 1000; ++p) {
            for (int a = 1; a < p; ++a) {
                for (int b = 1; b < p - a; ++b) {
                    if (isTriangular(a, b, p - a - b)) {
                        if (map.containsKey(p)) {
                            map.put(p, map.get(p) + 1);
                        } else {
                            map.put(p, 1);
                        }
                    }
                }
            }
        }
        
        int best = Integer.MIN_VALUE;
        int bestp = -1;
        
        for (final Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (best < e.getValue()) {
                best = e.getValue();
                bestp = e.getKey();
            }
        }
        
        System.out.println(bestp);
    }
    
    private boolean isTriangular(final int a, final int b, final int c) {
        return a * a + b * b == c * c;
    }
}
