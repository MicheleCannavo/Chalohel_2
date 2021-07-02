package chalohel.utility.console;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * The type Test output.
 */
@RunWith(Parameterized.class)
public class TestOutput {

    /**
     * The System out rule.
     */
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    /**
     * The Str.
     */
    private final String str;

    /**
     * Instantiates a new Test with string.
     *
     * @param str the str
     */
    public TestOutput(String str) {
        this.str = str;
    }

    /**
     * Gets param.
     *
     * @return the param
     */
    @Parameterized.Parameters
    public static Collection<String> getParam() {

        return Arrays.asList(
                "casa",
                "casetta mia",
                "La cassetta mia",
                "",
                "\0");
    }

    /**
     * Print line.
     */
    @Test
    public void printLine() {
        Output.printLine(str);
        assertEquals(str, systemOutRule.getLog());
    }

    /**
     * Test PrintnlLine.
     */
    @Test
    public void printnlLine() {
        Output.printnlLine(str);

        assertEquals(str + System.lineSeparator(),
                systemOutRule.getLog());
    }

    /**
     * Prints a string indicating the input is invalid.
     */
    @Test
    public void printNotValid() {
        Output.printNotValid();
        assertEquals("invalid input" + System.lineSeparator(),
                systemOutRule.getLog());
    }

    /**
     * Prints a string that communicates
     * that the object is already present and
     * that therefore the input is not allowed.
     */
    @Test
    public void printIsPresent() {
        String str = "subject matter";
        Output.printIsPresent(str);

        assertEquals(str + " is already present" + System.lineSeparator(),
                systemOutRule.getLog());
    }
}