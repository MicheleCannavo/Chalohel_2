package chalohel.utility.console;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestConsole {

  @Test
  public void myTab() {
    assertEquals("    ", Console.getMyTab());
  }
}