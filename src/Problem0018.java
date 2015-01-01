/**
 * Solves the problem 18: Maximum path sum I.
 */
public class Problem0018 extends AbstractProblem {

private static final int HEIGHT = 15;
    
private static final String DATA =
        "75 " +
        "95 64 " +
        "17 47 82 " +
        "18 35 87 10 " +
        "20 04 82 47 65 " +
        "19 01 23 75 03 34 " +
        "88 02 77 73 07 63 67 " +
        "99 65 04 28 06 16 70 92 " +
        "41 41 26 56 83 40 80 70 33 " +
        "41 48 72 33 47 32 37 16 94 29 " +
        "53 71 44 65 25 43 91 52 97 51 14 " +
        "70 11 33 28 77 73 17 78 39 68 17 57 " +
        "91 71 52 38 17 14 91 43 58 50 27 29 48 " +
        "63 66 04 68 89 53 67 30 73 16 69 87 40 31 " +
        "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

    @Override
    public void solve() {
        final int[][] triangle = getTriangle();
        
        for (final int[] row : triangle) {
            for (final int element : row) {
                System.out.print(element + " ");
            }
            
            System.out.println();
        }
    }
    
    private int[][] getTriangle() {
        final String[] numberStrings = DATA.split(" ");
        final int[] numbers = new int[numberStrings.length];
        
        for (int i = 0; i < numberStrings.length; ++i) {
            try {
                numbers[i] = Integer.parseInt(numberStrings[i]);
            } catch (final NumberFormatException nfe) {
                System.exit(1);
            }
        }
        
        final int[][] intTriangle = new int[HEIGHT][];
        
        for (int i = 0; i < HEIGHT; ++i) {
            intTriangle[i] = new int[i + 1];
        }
        
        for (int i = 0, x = 0, y = 0; i < numbers.length; ++i) {
            if (x == intTriangle[y].length) {
                x = 0;
                ++y;
            } 
            
            intTriangle[y][x++] = numbers[i];
        }
        
        return intTriangle;
    }
}
