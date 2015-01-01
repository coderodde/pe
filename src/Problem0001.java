/**
 * Solves the problem 1: Multiples of 3 and 5.
 */
public class Problem0001 extends AbstractProblem {

    @Override
    public void solve() {
        int sum = 0;
        
        for (int i = 3; i < 1000; ++i) {
            if (isMultipleOf3(i) || isMultipleOf5(i)) {
                sum += i;
            }
        }
        
        System.out.println(sum);
    }
    
    private static boolean isMultipleOf3(int number) {
        return isMultipleOf(number, 3);
    }
    
    private static boolean isMultipleOf5(int number) {
        return isMultipleOf(number, 5);
    }
    
    private static boolean isMultipleOf(int number, int factor) {
        return number % factor == 0;
    }
}
