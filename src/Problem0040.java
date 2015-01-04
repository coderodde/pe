/**
 * Solves the problem 40: 
 * @author rodionefremov
 */
public class Problem0040 extends AbstractProblem {

    @Override
    public void solve() {
        final StringBuilder sb = new StringBuilder(1100000);
        
        for (int i = 1; sb.length() <= 1000000; ++i) {
            sb.append(i);
        }
        
        final String str = sb.toString();
        int product = 1;
        
        try {
            for (int i = 1; i <= 1000000; i *= 10) {
                product *= Integer.parseInt(str.substring(i - 1, i));
            }
        } catch (final NumberFormatException nfe) {
            System.exit(1);
        }
        
        System.out.println(product);
    }
}
