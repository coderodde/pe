/**
 * Solves the problem 14: Longest Collatz sequence.
 */
public class Problem0014 extends AbstractProblem {

    @Override
    public void solve() {
        long longestSequenceNumber = -1L;
        long longestSequenceLength = Long.MIN_VALUE;
        
        for (long num = 999999L; num > 1L; --num) {
            final long len = Utils.collatzSequenceLenght(num);
            
            if (longestSequenceLength < len) {
                longestSequenceLength = len;
                longestSequenceNumber = num;
            }
        }
        
        System.out.println(longestSequenceNumber);
    }
}
