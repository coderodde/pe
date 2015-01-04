import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Solves the problem 26: Reciprocal cycles.
 */
public class Problem0026 extends AbstractProblem {

    @Override
    public void solve() {
        int longestCycleLength = Integer.MIN_VALUE;
        int longestCycleLengthD = -1;
        
        for (int d = 1; d < 1000; ++d) {
            final BigDecimal big = BigDecimal.ONE.divide(BigDecimal.valueOf(d), 5000, BigDecimal.ROUND_HALF_EVEN);
            final int tmp = countCycleLength(big.toString());
            
            if (longestCycleLength < tmp) {
                longestCycleLength = tmp;
                longestCycleLengthD = d;
            }
        }
       
        System.out.println(longestCycleLengthD);
    }
    
    private static final int countCycleLength(String s) {
        s = s.substring(2, s.length() - 5);
        
        final List<Character> work = new ArrayList<>(s.length());
        final List<Character> load = new ArrayList<>(s.length());
        
        int bestCycleLength = Integer.MIN_VALUE;
        
        for (int len = 1; len <= s.length(); ++len) {
            for (int i = s.length() - len; i < s.length() && i - len >= 0; ++i) {
                work.add(s.charAt(i));
                load.add(s.charAt(i - len));
            }
            
            if (Utils.listsHaveSameContent(work, load)) {
                if (bestCycleLength == len / 2 
                        && listRepeatsItself(work)) {
                    return bestCycleLength;
                }
                
                if (bestCycleLength < len) {
                    bestCycleLength = len;
                }
            }
            
            work.clear();
            load.clear();
        }   
        
        return bestCycleLength;
    }
    
    private static final <E> boolean listRepeatsItself(final List<E> list) {
        if (list.size() % 2 == 1) {
            return false;
        }
        
        for (int l = 0, r = list.size() / 2; r < list.size(); ++l, ++r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
        }
        
        return true;
    }
}
