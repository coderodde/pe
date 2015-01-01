
import java.util.HashMap;
import java.util.Map;

/**
 * Solves the problem 8: Largest product in a series.
 */
public class Problem0008 extends AbstractProblem {
    
    private static final int ROWS = 20;
    
    private static final int COLS = 50;
    
    private static final String DATA =
    "73167176531330624919225119674426574742355349194934" +
    "96983520312774506326239578318016984801869478851843" +
    "85861560789112949495459501737958331952853208805511" +
    "12540698747158523863050715693290963295227443043557" +
    "66896648950445244523161731856403098711121722383113" +
    "62229893423380308135336276614282806444486645238749" +
    "30358907296290491560440772390713810515859307960866" +
    "70172427121883998797908792274921901699720888093776" +
    "65727333001053367881220235421809751254540594752243" +
    "52584907711670556013604839586446706324415722155397" +
    "53697817977846174064955149290862569321978468622482" +
    "83972241375657056057490261407972968652414535100474" +
    "82166370484403199890008895243450658541227588666881" +
    "16427171479924442928230863465674813919123162824586" +
    "17866458359124566529476545682848912883142607690042" +
    "24219022671055626321111109370544217506941658960408" +
    "07198403850962455444362981230987879927244284909188" +
    "84580156166097919133875499200524063689912560717606" +
    "05886116467109405077541002256983155200055935729725" +
    "71636269561882670428252483600823257530420752963450";
    
    private static final int SEQ_LENGTH = 13;
    
    @Override
    public void solve() {
        final char[] seq = new char[SEQ_LENGTH];
        final Map<Character, Integer> map = new HashMap<>();
        
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        
        long largestProduct = Long.MIN_VALUE;
        
        for (int i = 0; i < DATA.length() - SEQ_LENGTH; ++i) {
            long tmpProduct = 1L;
            
            for (int j = 0; j < SEQ_LENGTH; ++j) {
                tmpProduct *= map.get(DATA.charAt(i + j));
            }
            
            if (largestProduct < tmpProduct) {
                largestProduct = tmpProduct;
            }
        }
        
        System.out.println(largestProduct);
    }
}
