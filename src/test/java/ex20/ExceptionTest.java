package ex20;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionTest {

    @Test(expected = NullPointerException.class)
    public void canExpectException() throws Exception {
        sayHelloTo("name");
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void canUseRuleToExpectException() {
        exception.expect(NullPointerException.class);
        sayHelloTo("name");
    }

    // diese Methode erzeugt eine NullPointerException
    private String sayHelloTo(String name) {
        String hello = null;

        hello.length();

        return name;
    }
}
