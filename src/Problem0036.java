/**
 * Solves the problem 36: Double-base palindromes.
 */
public class Problem0036 extends AbstractProblem {

    @Override
    public void solve() {
        long sum = 0L;
        
        for (long num = 1; num < 1000000L; ++num) {
            final String base10 = Long.toString(num);
            
            if (!Utils.isPalindromicArray(base10.toCharArray())) {
                continue;
            }
            
            final String base2 = Long.toString(num, 2);
            
            if (Utils.isPalindromicArray(base2.toCharArray())) {
                sum += num;
            }
        }
        
        System.out.println(sum);
    }
}
