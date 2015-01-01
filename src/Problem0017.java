/**
 * Solves the problem 17: Number letter counts.
 */
public class Problem0017 extends AbstractProblem {

    @Override
    public void solve() {
        int count = 0;
        
        for (int i = 1; i <= 1000; ++i) {
            final String numberString = literateNumber(i);
            count += countLetters(numberString);
            System.out.println(numberString + ": " + countLetters(numberString));
        }
        
        System.out.println(count);
    }
    
    private String literateNumber(final int num) {
        if (num == 1000) {
            return "one thousand";
        }
        
        if (num >= 100) {
            boolean addAnd = (num % 100) != 0;
            return getHundredsString(num / 100, addAnd) + getBelowHundred(num % 100);
        }
        
        return getBelowHundred(num);
    }
    
    private String getHundredsString(final int i, boolean addAnd) {
        final String and = " and ";
        
        switch (i) {
            case 1:
                return "one hundred" + (addAnd ? and : "");
                
            case 2:
                return "two hundred" + (addAnd ? and : "");
                
            case 3:
                return "three hundred" + (addAnd ? and : "");
                
            case 4:
                return "four hundred" + (addAnd ? and : "");
                
            case 5:
                return "five hundred" + (addAnd ? and : "");
                
            case 6:
                return "six hundred" + (addAnd ? and : "");
                
            case 7:
                return "seven hundred" + (addAnd ? and : "");
                
            case 8:
                return "eight hundred" + (addAnd ? and : "");
                
            case 9:
                return "nine hundred" + (addAnd ? and : "");
                
            default:
                throw new IllegalArgumentException("Should not happen.");
        }
    }
    
    private String getBelowHundred(final int num) {
        switch (num) {
            case 0:
                return "";
                
            case 1:
                return "one";
                
            case 2:
                return "two";
                
            case 3:
                return "three";
                
            case 4:
                return "four";
                
            case 5:
                return "five";
                
            case 6:
                return "six";
                
            case 7:
                return "seven";
                
            case 8:
                return "eight";
                
            case 9:
                return "nine";
                
            case 10:
                return "ten";
                
            case 11:
                return "eleven";
                
            case 12:
                return "twelve";
                
            case 13:
                return "thirteen";
                
            case 14:
                return "fourteen";
                
            case 15:
                return "fifteen";
                
            case 16:
                return "sixteen";
                
            case 17:
                return "seventeen";
                
            case 18:
                return "eighteen";
                
            case 19:
                return "nineteen";
        }
        
        final int tens = num / 10;
        final int leastSignificantDigit = num % 10;
        
        switch (tens) {
            case 2:
                return "twenty " + getBelowHundred(leastSignificantDigit);
                
            case 3:
                return "thirty " + getBelowHundred(leastSignificantDigit);
                
            case 4:
                return "forty " + getBelowHundred(leastSignificantDigit);
                
            case 5:
                return "fifty " + getBelowHundred(leastSignificantDigit);
                
            case 6:
                return "sixty " + getBelowHundred(leastSignificantDigit);
                
            case 7:
                return "seventy " + getBelowHundred(leastSignificantDigit);
                
            case 8:
                return "eighty " + getBelowHundred(leastSignificantDigit);
                
            case 9:
                return "ninety " + getBelowHundred(leastSignificantDigit);
                
            default:
                throw new IllegalArgumentException("Should not happen.");
        }
    }
    
    private int countLetters(final String s) {
        int count = 0;
        
        for (final char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                count++;
            }
        }
        
        return count;
    }
}
