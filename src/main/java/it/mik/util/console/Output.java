/*------------------------------------------------------------------------------
 - Copyright (c) 2021 Cannavo' Michele. All right reserved.
 -
 -  This file is part of UtilConsole
 -
 -     UtilConsole is free software: you can redistribute it and/or modify
 -     it under the terms of the Lesser GNU General Public License as published by
 -     the Free Software Foundation, either version 3 of the License, or
 -     (at your option) any later version.
 -
 -     UtilConsole is distributed in the hope that it will be useful,
 -     but WITHOUT ANY WARRANTY; without even the implied warranty of
 -     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 -     Lesser GNU General Public License for more details.
 -
 -     You should have received a copy of the Lesser GNU General Public License
 -     along with UtilConsole.  If not, see <http://www.gnu.org/licenses/>.
 -----------------------------------------------------------------------------*/

package util.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

/**
 * Class for OUTPUT management.
 *
 * @author    Michele Cannavo'
 * @copyright © 2021 - Cannavo' Michele
 * @license   LGPL 3.0
 * @date      10/06/2021
 * @since     1.0.0
 * @version   1.3.0
 * @mod       12/06/2021, Add printIsPresent(String item)
 * @test      as

 */
public final class Output {

  private static final Logger LOGGER  =
    LoggerFactory.getLogger(Output.class);

  /**
   * Static class.
   */
  private Output() {
  }

  /**
   * Print a string with lineSeparator().
   *
   * @param format The format of the string.
   * @param args   The arguments of the string.
   *
   * @since 1.0.0
   */
  public static void printLine(String format, Object... args) {

    try{
      System.console().printf(format, args);
    } catch(NullPointerException ex) {
      LOGGER.warn("Console not found. System.out will be used" );
      System.out.printf(format, Arrays.toString(args));
    }finally {
      LOGGER.debug("The entered value is: %s", args );
    }
  }

  /**
   * Print a string with lineSeparator().
   *
   * @param format The format of the string.
   * @param args   The arguments of the string.
   *
   * @since 1.0.0
   */
  public static void printnlLine(String format, Object... args) {
    printLine(format+ System.lineSeparator(), Arrays.toString(args) );
  }

  /**
   * Print the string "invalid input".
   * It then generates a newline.
   *
   * @since 1.1.0
   */
  public static void printNotValid() {
    String notValid = "invalid input";
    printnlLine(notValid);
  }

  /**
   * Print the string "_item_ is already present".
   * It then generates a newline.
   *
   * @param item the item already present.
   * @since 1.1.0
   */
  public static void printIsPresent(String item) {
    String notValid = item + " is already present";
    printnlLine(notValid);
  }
}