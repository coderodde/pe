/**
 * Solves the problem 4: Largest palindrome product.
 */
public class Problem0004 extends AbstractProblem {

    @Override
    public void solve() {
        long largestPalindromicNumber = Long.MIN_VALUE;
        
        for (long a = 100L; a < 1000L; ++a) {
            for (long b = 100L; b < 1000L; ++b) {
                long product = a * b;
                
                if (Utils.isPalindromicNumber(product)) {
                    if (largestPalindromicNumber < product) {
                        largestPalindromicNumber = product;
                    }
                }
            }
        }
        
        System.out.println(largestPalindromicNumber);
    }
}
