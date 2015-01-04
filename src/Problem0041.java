/**
 * Solves the problem 41: Pandigital prime.
 */
public class Problem0041 extends AbstractProblem {

    @Override
    public void solve() {
        // 9 and 8 give no desired number.
        final int numberLength = 7;
        
        final Integer[] array = new Integer[numberLength];
        
        for (int i = array.length; i > 0; --i) {
            array[array.length - i] = i;
        }
        
        boolean ok = true;
        
        for (; ok; ok = Utils.permuteBack(array)) {
            
            if (array[array.length - 1] % 2 == 0) {
                continue;
            }
            
            final long num = Utils.buildLongFromDigits(array);
            
            if (Utils.isPrime(num) && Utils.isPandigital(num)) {
                System.out.println(num);
                return;
            }
        }
    }
}
