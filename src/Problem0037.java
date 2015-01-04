/**
 * Solves the problem 37: Truncatable primes.
 */
public class Problem0037 extends AbstractProblem {

    @Override
    public void solve() {
        int sum = 0;
        int found = 0;
        
        for (int num = 11; found < 11; num = (int) Utils.nextPrime(num)) {
            if (isTruncatable(num)) {
                ++found;
                sum += num;
            }
        }
        
        System.out.println(sum);
    }
    
    private boolean isTruncatable(final int num) {
        final String str = Integer.toString(num);
        
        try {
            for (int begin = 1; begin < str.length(); ++begin) {
                if (!Utils.isPrime(Integer.parseInt(str.substring(begin)))) {
                    return false;
                }
            }
            
            for (int end = str.length() - 1; end > 0; --end) {
                if (!Utils.isPrime(Integer.parseInt(str.substring(0, end)))) {
                    return false;
                }
            }
        } catch (final NumberFormatException nfe) {
            return false;
        }
        
        return true;
    }
}
