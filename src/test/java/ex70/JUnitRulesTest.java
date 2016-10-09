package ex70;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.rules.Timeout;
import org.junit.runner.Description;

import java.util.concurrent.TimeUnit;

public class JUnitRulesTest {

    @Rule
    public TestName testName = new TestName();

    @Rule
    public TestRule timeout = new DisableOnDebug(new Timeout(10, TimeUnit.SECONDS));

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void starting(Description description) {
            System.out.println("start " + description.getMethodName());
        }

        @Override
        protected void succeeded(Description description) {
            System.out.println("done " + description.getMethodName());
        }
    };

    @Test
    public void canPrintTestName() throws Exception {
        System.out.println(testName.getMethodName());
    }

    @Test
    public void longRunningTest() throws Exception {
        for (int x = 0; x < 12; ++x) {
            Thread.sleep(1000);
        }
    }
}
