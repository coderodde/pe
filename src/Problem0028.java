
import java.awt.Point;

/**
 * Solves the problem 28: Number spiral diagonals.
 */
public class Problem0028 extends AbstractProblem {

    private static final int N = 1001;
    
    private static final int RIGHT = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int UP = 3;
    
    private int direction;
    
    @Override
    public void solve() {
        final int[][] m = getMatrix(N);
//        print(m);
        
        int sum = 0;
        
        for (int i = 0; i < m.length; ++i) {
            sum += m[i][i];
        }
        
        for (int y = 0, x = m.length - 1; y < m.length; ++y, --x) {
            sum += m[y][x];
        }
        
        --sum;
        
        System.out.println(sum);
    }
    
    private int[][] getMatrix(final int n) {
        int[][] m = new int[n][n];
        Point p = new Point(n / 2, n / 2);
        m[n / 2][n / 2] = 1;
        direction = RIGHT;
        int num = 2;
        
        for (int len = 1; len < n; ++len) {
            for (int c = 0; c < 2; ++c, nextDirection()) {
                for (int i = 0; i < len; ++i, ++num) {
                    switch (direction) {
                        case RIGHT:
                            p.x++;
                            break;

                        case DOWN:
                            p.y++;
                            break;

                        case LEFT:
                            p.x--;
                            break;

                        case UP:
                            p.y--;
                            break;

                        default:
                            throw new IllegalStateException();
                    }
                    
                    m[p.y][p.x] = num;
                }
            }
        }
        
        for (int x = 1; x < n; ++x, ++num) {
            m[0][x] = num;
        }
        
        return m;
    }
    
    private void nextDirection() {
        switch (direction) {
            case RIGHT:
                direction = DOWN;
                break;
                
            case DOWN:
                direction = LEFT;
                break;
                
            case LEFT:
                direction = UP;
                break;
                
            case UP:
                direction = RIGHT;
                break;
                
            default:
                throw new IllegalStateException();
        }
    }
    
    private void print(final int[][] m) {
        for (final int[] row : m) {
            for (final int i : row) {
                System.out.printf("%2d ", i);
            }
            
            System.out.println();
        }
    }
}
