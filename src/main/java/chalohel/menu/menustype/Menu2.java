package chalohel.menu.menustype;

import chalohel.menu.action.*;
import chalohel.menu.Items.Iitem;

/**
 * The type Menu 2.
 */
public class Menu2 extends AbstractMenu {

    /**
     * Instantiates a new Menu 2.
     */
    public Menu2 () {
        title = "GESTIONE PROGETTO";
        lengthDivisor = title.length();
        listMenu.put(1, new Iitem("LOGIN", new Login()));
    }
}
