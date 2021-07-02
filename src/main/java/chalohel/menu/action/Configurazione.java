/*
 *  Copyright (c) 2021 Cannavo' Michele. All right reserved.
 *
 *   This file is part of CHALOHEL
 *
 *       UtilConsole is free software: you can redistribute it and/or modify
 *       it under the terms of the Lesser GNU General Public License as published by
 *       the Free Software Foundation, either version 3 of the License, or
 *       (at your option) any later version.
 *
 *       CHALOHEL is distributed in the hope that it will be useful,
 *       but WITHOUT ANY WARRANTY; without even the implied warranty of
 *       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *       Lesser GNU General Public License for more details.
 *
 *   You should have received a copy of the Lesser GNU General Public License
 *   along with CHALOHEL.  If not, see <http://www.gnu.org/licenses/>.
 */
package chalohel.menu.action;

import chalohel.utility.console.Output;

/**
 * Config.
 * @startuml
 * class chalohel.menu.action.Configurazione {
 * + String getNameAction()
 * + void run()
 * }
 *
 *
 * chalohel.menu.action.Iaction <|.. chalohel.menu.action.Configurazione
 * @enduml
 */
public class Configurazione implements Iaction {

  /**
   * The constant action.
   *
   * @return the name action
   */
  public String getNameAction () {
    return "Configurazione";
  }


  /**
   * Run.
   *
   */
  public void run() {
    Output.printLine(getNameAction());
  }
}