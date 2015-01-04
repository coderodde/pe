/**
 * Solves the problem 31: Coin sums.
 */
public class Problem0031 extends AbstractProblem {

    private static final int TARGET = 200;
    
    private int ways;
    
    private static final int[] coins = new int[] {
                                1, 
                                2, 
                                5, 
                                10, 
                                20,
                                50,
                                100,
                                200,
                            };
    
    @Override
    public void solve() {
        ways = 0;
        solveImpl(TARGET, 0);
        System.out.println(ways);
    }
    
    private void solveImpl(final int left, final int firstCoinIndex) {
        if (left == 0) {
            ways++;
            return;
        }
        
        for (int i = firstCoinIndex; i < coins.length; ++i) {
            final int currentCoin = coins[i];
            if (currentCoin <= left) {
                solveImpl(left - currentCoin, i);
            }
        }
    }
}
