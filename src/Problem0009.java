/**
 * Solves the problem 9: Special Pythagorean triplet.
 */
public class Problem0009 extends AbstractProblem {

    @Override
    public void solve() {
        for (long a = 1L; a < 999L; ++a) {
            for (long b = 1L; b + a < 1000L; ++b) {
                if (Utils.isPythagoreanTriplet(a, b, 1000L - a - b)) {
                    System.out.println(a * b * (1000L - a - b));
                    return;
                }
            }
        }
    }
}
