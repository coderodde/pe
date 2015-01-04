
import java.util.HashSet;
import java.util.Set;

/**
 * Solve the problem 38: Pandigital multiples.
 */
public class Problem0038 extends AbstractProblem {
    
    private final Set<Character> set = new HashSet<>();
    private final StringBuilder sb = new StringBuilder();
    
    @Override
    public void solve() {
        int largest = Integer.MIN_VALUE;
        
        for (int num = 1; num < 10000; ++num) {
            for (int n = 1; n < 10; ++n) {
                final int[] array = new int[n];
                
                for (int i = 0; i < n; ++i) {
                    array[i] = (i + 1) * num;
                }
                
                final int tmp = get9Pandigital(array);
                
                if (largest < tmp) {
                    largest = tmp;
                }
            }
        }
        
        System.out.println(largest);
    }
    
    public int get9Pandigital(final int[] array) {
        final String[] strArray = new String[array.length];
        int numLength = 0;
        
        for (int i = 0; i < array.length; ++i) {
            strArray[i] = Integer.toString(array[i]);
            numLength += strArray[i].length();
        }
        
        if (numLength > 9) {
            return Integer.MIN_VALUE;
        }
        
        set.clear();
        
        for (final String s : strArray) {
            for (final char c : s.toCharArray()) {
                set.add(c);
            }
        }
        
        if (set.size() > 9) {
            return Integer.MIN_VALUE;
        } 
        
        char c = '1';
        for (int i = 0; i < set.size(); ++i, ++c) {
            if (!set.contains(c)) {
                return Integer.MIN_VALUE;
            }
        }
        
        sb.delete(0, sb.length());
        
        for (final String s : strArray) {
            sb.append(s);
        }
        
        try {
            return Integer.parseInt(sb.toString());
        } catch (final NumberFormatException nfe) {
            return Integer.MIN_VALUE;
        }
    }
}
