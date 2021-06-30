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
/**
 * Classi e metodi funzionali per le console.
 *
 * @author      Cannavo' Michele
 * @copyright   © 2021 - Cannavo' Michele
 * @license     LGPL 3.0
 * @date        03/06/2021
 * @version     1.3.0
 * @since       1.2.0
 * @mod         11/06/2021, Cannavo' Michele
 *
 * @class Input
 * @startuml class util.console.Input {
 * - <<Create>> Input()
 * + {static} String readLine(String,Object)
 * + {static} String readPassword()
 * }
 * @enduml
 *
 * @class Output
 * @startuml
 * class util.console.Output {
 * - <<Create>> Output()
 * + {static} void printLine(String,Object)
 * + {static} void printnlLine(String,Object)
 * + {static} void printNotValid()
 * + {static} void printIsPresent(String)
 * }
 * @enduml
 *
 * @class Console
 * @startuml
 * class util.console.Console {
 * - <<Create>> Console()
 * + {static} void clrscr()
 * }
 * @enduml
 */

package util.console;