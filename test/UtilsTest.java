import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilsTest {
    
    @Test
    public void testIsPrime() {
        for (long l = -10; l < 2L; ++l) {
            assertFalse(Utils.isPrime(l));
        }
        
        assertTrue(Utils.isPrime(2L));
        assertTrue(Utils.isPrime(3L));
        assertFalse(Utils.isPrime(4L));
        assertTrue(Utils.isPrime(5L));
        assertFalse(Utils.isPrime(6L));
        assertTrue(Utils.isPrime(7L));
        assertFalse(Utils.isPrime(8L));
        assertFalse(Utils.isPrime(9L));
        assertFalse(Utils.isPrime(10L));
        assertTrue(Utils.isPrime(11L));
    }
    
    @Test
    public void testNextPrime() {
        for (long l = -10L; l < 2L; ++l) {
            assertEquals(2L, Utils.nextPrime(l));
        }
        
        assertEquals(3L, Utils.nextPrime(2L));
        assertEquals(5L, Utils.nextPrime(3L));
        assertEquals(5L, Utils.nextPrime(4L));
        assertEquals(7L, Utils.nextPrime(5L));
        assertEquals(7L, Utils.nextPrime(6L));
        
        for (long l = 7l; l < 11L; ++l) {
            assertEquals(11L, Utils.nextPrime(l));
        }
        
        assertEquals(13L, Utils.nextPrime(11L));
        assertEquals(13L, Utils.nextPrime(12L));
    }
    
    @Test
    public void testFactorize() {
        final long num = 3780L;
        final List<Long> factors = Utils.factorize(num);
        assertTrue(2L == factors.get(0));
        assertTrue(2L == factors.get(1));
        assertTrue(3L == factors.get(2));
        assertTrue(3L == factors.get(3));
        assertTrue(3L == factors.get(4));
        assertTrue(5L == factors.get(5));
        assertTrue(7L == factors.get(6));
    }
    
    @Test
    public void testFactorizeAndCompress() {
        final long num = 3780L;
        final Map<Long, Integer> map = Utils.factorizeAndCompress(num);
        assertTrue(map.get(2L) == 2);
        assertTrue(map.get(3L) == 3);
        assertTrue(map.get(5L) == 1);
        assertTrue(map.get(7L) == 1);
        
        final Set<Long> keys = map.keySet();
        
        assertEquals(4, keys.size());
        assertTrue(keys.contains(2L));
        assertTrue(keys.contains(3L));
        assertTrue(keys.contains(5L));
        assertTrue(keys.contains(7L));
    }
    
    @Test
    public void testArithmeticSum() {
        assertEquals(1, Utils.arithmeticSum(1, 1));
        assertEquals(3, Utils.arithmeticSum(1, 2));
        assertEquals(6, Utils.arithmeticSum(1, 3));
        
        assertEquals(18, Utils.arithmeticSum(3, 6));
        assertEquals(45, Utils.arithmeticSum(5, 10));
    }
    
    @Test
    public void testSquareSum() {
        assertEquals(1L, Utils.squareSum(1L));
        assertEquals(5L, Utils.squareSum(2L));
        assertEquals(14L, Utils.squareSum(3L));
        assertEquals(30L, Utils.squareSum(4L));
        
        assertEquals(41L, Utils.squareSum(4L, 5L));
        assertEquals(50L, Utils.squareSum(3L, 5L));
        assertEquals(54L, Utils.squareSum(2L, 5L));
        assertEquals(55L, Utils.squareSum(1L, 5L));
    }
    
    @Test
    public void testFactorial() {
        assertEquals(1L, Utils.factorial(1L));
        assertEquals(2L, Utils.factorial(2L));
        assertEquals(6L, Utils.factorial(3L));
        assertEquals(24L, Utils.factorial(4L));
    }
    
    @Test
    public void testGeneralFactorial() {
        assertEquals(1L, Utils.generalFactorial(1L, 1L));
        assertEquals(2L, Utils.generalFactorial(2L, 1L));
        assertEquals(6L, Utils.generalFactorial(3L, 1L));
        assertEquals(24L, Utils.generalFactorial(4L, 1L));
        
        assertEquals(24L, Utils.generalFactorial(4L, 2L));
        assertEquals(12L, Utils.generalFactorial(4L, 3L));
        assertEquals(4L, Utils.generalFactorial(4L, 4L));
    }
    
    @Test
    public void testBinomial() {
        assertEquals(1L, Utils.binomial(1L, 1L));
        assertEquals(2L, Utils.binomial(2L, 1L));
        assertEquals(1L, Utils.binomial(2L, 2L));
        assertEquals(1L, Utils.binomial(2L, 0L));
        assertEquals(6L, Utils.binomial(4L, 2L));
    }
    
    @Test
    public void testGetDivisors() {
        // 1, 2, 3, 5, 6, 10, 15, 30
        final List<Long> divisors = Utils.getDivisors(30L);
        assertTrue(1L == divisors.get(0));
        assertTrue(2L == divisors.get(1));
        assertTrue(3L == divisors.get(2));
        assertTrue(5L == divisors.get(3));
        assertTrue(6L == divisors.get(4));
        assertTrue(10L == divisors.get(5));
        assertTrue(15L == divisors.get(6));
        assertTrue(30L == divisors.get(7));
        assertEquals(8, divisors.size());
    }
    
    @Test
    public void testGetProperDivisors() {
        final List<Long> divisors = Utils.getProperDivisors(30L);
        assertTrue(1L == divisors.get(0));
        assertTrue(2L == divisors.get(1));
        assertTrue(3L == divisors.get(2));
        assertTrue(5L == divisors.get(3));
        assertTrue(6L == divisors.get(4));
        assertTrue(10L == divisors.get(5));
        assertTrue(15L == divisors.get(6));
        assertEquals(7, divisors.size());
    }
    
    @Test
    public void testPermute() {
        Integer[] array = new Integer[]{ 2, 1, 0 };
        
        assertFalse(Utils.permute(array));
        
        assertTrue(array[0] == 2);
        assertTrue(array[1] == 1);
        assertTrue(array[2] == 0);
        
    }
}
