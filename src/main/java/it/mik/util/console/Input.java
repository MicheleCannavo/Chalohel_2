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
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class for INPUT management.
 *
 * @author    Michele Cannavo'
 * @version   1.1.0
 * @copyright © 2021 - Cannavo' Michele
 * @license   LGPL 3.0
 * @date      10/06/2021
 * @since     1.0.0
 */
public final class Input {
  private static final Logger LOGGER =
    LoggerFactory.getLogger(Input.class);

  /**
   * Static class.
   */
  private Input() {
  }

  /**
   * After printing a message, fetch from console or System.in,
   * if there shouldn't be a console connected,
   * an input as a string and returns it to the caller.
   *
   * @param   format  the format from the string for the message.
   * @param   args    The topics of the message.
   *
   * @return  The input entered as a string.
   *
   * @since   1.0.0
   */
  public static String readLine(String format, Object... args) {
    Scanner scanner = new Scanner(new InputStreamReader(System.in));
    try {
      return System.console().readLine(format, args);
    } catch (NullPointerException excep1) {
        System.out.printf(format, args);
        return scanner.nextLine();
    }
  }


  /**
   * After printing the message: "password: ".
   * Allows entry of a password from console
   * as it happens in linux consoles,
   * that is, without showing the characters on the video.
   * If there is no console connected,
   * the input is done as for a normal string.
   *
   * @return L'input immesso sotto forma di stringa.
   *
   * @since 1.0.0
   */
  public static String readPassword() {
    String message = "Enter password: ";
    try {
      return Arrays.toString(System.console().readPassword(message));
    } catch (NullPointerException ex) {
      LOGGER.warn("Password is visible: ".concat(ex.getMessage()));
      return readLine(message);
    }
  }
}