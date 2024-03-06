package fundamentals.labs.lab05.lab05_01;

import org.junit.*;

import static org.junit.Assert.assertTrue;

public class TestSingleton {

    // testing if the same instance is guaranteed
    @Test
    public void testIfSameInstanceIsReturned(){
        MySingleton instance1 =  MySingleton.getInstance();
        MySingleton instance2 = MySingleton.getInstance();
        MySingleton instance3 = MySingleton.getInstance();

        assertTrue(instance1 == instance2);
        assertTrue(instance1 == instance3);
    }

    // testing if the only one instances is created
    @Test
    public void testIfSingleInstanceIsCreated(){
        MySingleton.getInstance();
        MySingleton.getInstance();
        MySingleton.getInstance();
        MySingleton.getInstance();
        MySingleton.getInstance();
        MySingleton.getInstance();

        assertTrue(MySingleton.count == 1);
    }

}
