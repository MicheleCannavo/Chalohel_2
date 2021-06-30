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
import java.io.IOException;

/**
 * Method management class.
 *
 * @brief Class for managing methods for consoles.
 *
 * @author    Michele Cannavo'
 * @copyright ©2021 - Michele Cannavo'
 * @license   LGPL 3.0
 * @mod       17/05/2021, Cannavo' Michele
 * @since     1.0.0
 * @version   1.3.0
 *
 * @startuml
 * class util.console.Console {
 * - <<Create>> Console()
 * + {static} void clrscr()
 * }
 * @enduml
 */
public final class Console {


  /**
   * Costruttore privato
   */
  private Console() {  }

  /** Variable for the LOG */
  private static final Logger LOGGER  =
    LoggerFactory.getLogger(Console.class);

  /**
   * Method that "cleans" the console.
   * In the event of an error, the active Thread () terminates.
   *
   * @since 1.0.0
   */
  @SuppressWarnings("unused")
  public static void clrscr() {

    try {
      if(System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("windows/system32/cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        Runtime.getRuntime().exec("/usr/bin/clear");
      }
    } catch(IOException | InterruptedException | NullPointerException  ex) {
      LOGGER.warn("Error clearing the console: ".concat(ex.getMessage()));
      Thread.currentThread().interrupt();
    }
  }
}