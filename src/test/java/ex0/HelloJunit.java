package ex0;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloJunit {

    /*
        seit JUnit4 müssen Testmethoden *nicht* mehr testXYZ heissen!
     */
    @Test
    public void helloJunit() throws Exception {
        String actual = "hello" + "junit";
        
        assertEquals("hello junit", actual);
    }
}
