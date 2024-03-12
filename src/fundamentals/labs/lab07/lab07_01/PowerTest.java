package fundamentals.labs.lab07.lab07_01;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class PowerTest {

    @Test
    public void Testing2Power10(){
        double expectation = Math.pow(2,10);
        double result = new Exponential().power(2,10);
        assertTrue( expectation == result );
    }

    @Test
    public void TestingDouble2Power10(){
        double expectation = Math.pow(2.7,7);
        double result = new Exponential().power(2.7,7);
        assertTrue( Double.valueOf(expectation).equals(result));
    }
}
