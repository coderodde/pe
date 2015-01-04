import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solves the problem 33: Digit cancelling fractions.
 */
public class Problem0033 extends AbstractProblem {

    @Override
    public void solve() {
        int numeratorProduct = 1;
        int denominatorProduct = 1;
        
        for (int numerator = 10; numerator < 100; ++numerator) {
            for (int denominator = numerator + 1; denominator < 100; ++denominator) {
                if (fractionMayBeCancelled(numerator, denominator)) {
                    numeratorProduct *= numerator;
                    denominatorProduct *= denominator;
                }
            }
        }
        
        System.out.println(numeratorProduct + " * " + denominatorProduct);
        
        final Map<Long, Integer> numeratorMap = Utils.factorizeAndCompress(numeratorProduct);
        final Map<Long, Integer> denominatorMap = Utils.factorizeAndCompress(denominatorProduct);
        final Set<Long> set = new HashSet<>();
        
        set.addAll(denominatorMap.keySet());
        
        for (final Long prime : set) {
            if (!numeratorMap.containsKey(prime)) {
                continue;
            }
            
            final int countNumerator = numeratorMap.get(prime);
            final int countDenominator = denominatorMap.get(prime);
            denominatorMap.put(prime, Math.max(0, countDenominator - countNumerator));
        }
        
        long product = 1L;
        
        for (final Map.Entry<Long, Integer> e : denominatorMap.entrySet()) {
            product *= Math.pow(e.getKey(), e.getValue());
        }
        
        System.out.println(product);
    }
    
    private boolean fractionMayBeCancelled(final int numerator,
                                           final int denominator) {
        final char[] numeratorChars = Integer.toString(numerator).toCharArray();
        final char[] denominatorChars = Integer.toString(denominator).toCharArray();
        
        boolean hasSameDigits = false;
        char sameDigit = '\u0000';
        
        for (final char c :numeratorChars) {
            if (c == denominatorChars[0] || c == denominatorChars[1]) {
                hasSameDigits = true;
                sameDigit = c;
                break;
            }
        }
        
        if (!hasSameDigits || sameDigit == '0') {
            return false;
        }
        
        StringBuilder sb = new StringBuilder();
        
        String newNumeratorString;
        String newDenominatorString;
        
        if (numeratorChars[0] == sameDigit) {
            sb.append(numeratorChars[1]);
        } else {
            sb.append(numeratorChars[0]);
        }
        
        newNumeratorString = sb.toString();
        sb = new StringBuilder();
        
        if (denominatorChars[0] == sameDigit) {
            sb.append(denominatorChars[1]);
        } else {
            sb.append(denominatorChars[0]);
        }
        
        newDenominatorString = sb.toString();
        
        int newNumerator;
        int newDenominator;
        
        try {
            newNumerator = Integer.parseInt(newNumeratorString);
            newDenominator = Integer.parseInt(newDenominatorString);
        } catch (final NumberFormatException nfe) {
            return false;
        }
        
        boolean yes = numerator * newDenominator == denominator * newNumerator;
        
        if (yes) {
            System.out.println(numerator + "/" + denominator + " = " + newNumerator + "/" + newDenominator);
        }
        
        return yes;
    }
}
