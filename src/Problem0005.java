
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solves the problem 5: Smallest multiple.
 */
public class Problem0005 extends AbstractProblem {

    private static final long TARGET = 20L;
    
    @Override
    public void solve() {
        final List<Map<Long, Integer>> list = new ArrayList<>((int)(TARGET - 1));
        
        for (long num = 2L; num <= TARGET; ++num) {
            list.add(Utils.factorizeAndCompress(num));
        }
        
        final Map<Long, Integer> mapResult = new HashMap<>();
        
        for (final Map<Long, Integer> map : list) {
            for (final Map.Entry<Long, Integer> entry : map.entrySet()) {
                if (!mapResult.containsKey(entry.getKey())) {
                    mapResult.put(entry.getKey(), 1);
                } else {
                    final int current = mapResult.get(entry.getKey());
                    
                    if (current < entry.getValue()) {
                        mapResult.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        
        long l = 1L;
        
        for (final Map.Entry<Long, Integer> entry : mapResult.entrySet()) {
            l *= Math.pow(entry.getKey(), entry.getValue());
        }
        
        System.out.println(l);
    }
}
