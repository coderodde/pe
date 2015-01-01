/**
 * Solves the problem 2: Even Fibonacci numbers.
 */
public class Problem0002 extends AbstractProblem {

    @Override
    public void solve() {
        long a = 1L;
        long b = 2L;
        long sum = 0L;
        
        while (b <= 4000000L) {
            if ((b & 1) == 0) {
                // b is even. Add to sum.
                sum += b;
            }
            
            // Progress to the next Fibonacci number.
            long tmp = a;
            a = b;
            b += tmp;
        }
        
        System.out.println(sum);
    }
}
