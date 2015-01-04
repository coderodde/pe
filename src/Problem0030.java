/**
 * Solves the problem 30: Digit fifth power.
 */
public class Problem0030 extends AbstractProblem {

    /*
    It seems that the range [1 ... 999999] is enough wide to include all the
    target number.
    */
    @Override
    public void solve() {
        long sumOfNumbers = 0L;
        
        for (long i = 2L; i < 1000000L; ++i) {
            final int[] digits = Utils.toDigit(i);
            
            long sum = 0;
            
            for (final int digit : digits) {
                sum += (int) Math.pow(digit, 5);
            }
            
            if (sum == i) {
                sumOfNumbers += sum;
            }
        }
        
        System.out.println(sumOfNumbers);
    }
}
