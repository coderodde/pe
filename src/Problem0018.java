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

private static final int DEMO_HEIGHT = 4;

private static final String DEMO_DATA =
        "3 " +
        "7 4 " +
        "2 4 6 " +
        "8 5 9 3";

    @Override
    public void solve() {
        final String[] parsedStrings = DATA.split(" ");
        final int[][] triangle = getTriangle(parsedStrings, HEIGHT);
        final int[][] memory = getWorkingMemory(triangle);
        memory[0][0] = triangle[0][0];
        
        for (int row = 1; row < memory.length; ++row) {
            for (int col = 0; col < memory[row].length; ++col) {
                
                int leftParent = col - 1;
                int rightParent = col;
                
                if (leftParent < 0) {
                    leftParent = 0;
                }
                
                if (rightParent >= memory[row - 1].length) {
                    rightParent = memory[row - 1].length - 1;
                }
                
                if (memory[row][col] < memory[row - 1][leftParent] + triangle[row][col]) {
                    memory[row][col] = memory[row - 1][leftParent] + triangle[row][col];
                }
                
                if (memory[row][col] < memory[row - 1][rightParent] + triangle[row][col]) {
                    memory[row][col] = memory[row - 1][rightParent] + triangle[row][col];
                }
            }
        }
        
        for (final int[] row : triangle) {
            for (final int element : row) {
                System.out.print(element + " ");
            }
            
            System.out.println();
        }
        
        System.out.println();
        
        for (final int[] row : memory) {
            for (final int element : row) {
                System.out.print(element + " ");
            }
            
            System.out.println();
        }
        
        System.out.println();
        
        int largest = Integer.MIN_VALUE;
        
        for (final int i : memory[memory.length - 1]) {
            if (largest < i) {
                largest = i;
            }
        }
        
        System.out.println(largest);
    }
    
    private int[][] getTriangle(final String[] numberStrings, final int height) {
        final int[] numbers = new int[numberStrings.length];
        
        for (int i = 0; i < numberStrings.length; ++i) {
            try {
                numbers[i] = Integer.parseInt(numberStrings[i]);
            } catch (final NumberFormatException nfe) {
                System.exit(1);
            }
        }
        
        final int[][] intTriangle = new int[height][];
        
        for (int i = 0; i < height; ++i) {
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
    
    private int[][] getWorkingMemory(final int[][] triangle) {
        final int[][] memory = new int[triangle.length][];
        
        for (int i = 0; i < triangle.length; ++i) {
            memory[i] = new int[triangle[i].length];
        }
        
        return memory;
    }
}
