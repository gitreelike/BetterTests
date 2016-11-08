package ex51;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MoreThanOneTest {

    @Test
    @Parameters(method = "names")
    public void controlStructures(String param) throws Exception {
        assertThat(param).doesNotContain("x");
    }

    Object[] names() {
        return new Object[]{"Kirk", "Zulu", "McCoy", "Spock"};
    }

}
