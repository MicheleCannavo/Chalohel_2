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
/**
 * Share action package.
 *
 * @author  Michele Cannavo'
 * @since   0.1.2
 * @version 0.1.2
 *
 * @startuml
 * interface chalohel.menu.action.Iaction {
 * }
 * class chalohel.menu.action.Configurazione {
 * }
 * class chalohel.menu.action.Item {
 * }
 * class chalohel.menu.action.Login {
 * }
 * class chalohel.menu.action.Registrazione {
 * }
 *
 * chalohel.menu.action.Iaction <|.. chalohel.menu.action.Configurazione
 * chalohel.menu.action.Iaction <|.. chalohel.menu.action.Login
 * chalohel.menu.action.Iaction <|.. chalohel.menu.action.Registrazione
 * @enduml
 */
package chalohel.menu.action;