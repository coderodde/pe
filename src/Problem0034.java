/**
 * Solves the problem 34: Digit factorials.
 */
public class Problem0034 extends AbstractProblem {

    private static final int UPPER_BOUND = 999999;
    
    @Override
    public void solve() {
        int total = 0;
        
        for (int num = 10; num <= UPPER_BOUND; ++num) {
            final int[] digits = Utils.toDigit(num);
            long digitFactorialSum = 0;
            
            for (final int digit : digits) {
                digitFactorialSum += Utils.factorial(digit);
            }
            
            if (digitFactorialSum == num) {
                System.out.println(num + " " + digitFactorialSum);
                total += num;
            }
        }
        
        System.out.println(total);
    }
}
