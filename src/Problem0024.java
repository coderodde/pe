/**
 * Solves the problem 24: Lexicographic permutations. 
 */
public class Problem0024 extends AbstractProblem {

    @Override
    public void solve() {
        final Integer[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        
        // The first permutation is here. Permute 999 999 more times.
        for (int i = 0; i < 999999; ++i) {
            Utils.permute(arr);
        }
       
        final StringBuilder sb = new StringBuilder();
        
        for (final int i : arr) {
            sb.append(i);
        }
        
        System.out.println(sb.toString());
    }
}
