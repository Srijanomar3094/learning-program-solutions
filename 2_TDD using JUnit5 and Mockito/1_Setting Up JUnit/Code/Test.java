import org.junit.Test;
import static org.junit.Assert.*;

public class Test {
    
    @Test
    public void testAddition() {
        int result = 2 + 3;
        assertEquals(5, result);
    }
    
    @Test
    public void testSubtraction() {
        int result = 10 - 3;
        assertEquals(7, result);
    }
    
    @Test
    public void testMultiplication() {
        int result = 4 * 5;
        assertEquals(20, result);
    }
}