package chalohel.menu.menustype;

import chalohel.menu.Items.Iitem;
import chalohel.menu.action.Configurazione;
import chalohel.menu.action.Login;
import chalohel.menu.action.Registrazione;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Menu 1.
 */
public class Menu1 extends AbstractMenu {

    private static final Logger LOGGER  =
      LoggerFactory.getLogger(Menu1.class);

    private static Menu1 instance = null;

    /**
     * Instantiates a new Menu 1.
     */
    private Menu1 () {
        title = "CHALOHEL";
        LOGGER.debug(" Titolo: {}, dim: {}", title, lengthDivisor);

        listMenu.put(++count, new Iitem("LOGIN", new Login()));
        LOGGER.debug(" Item: {}",  listMenu.get(count));

        listMenu.put(++count, new Iitem("REGISTRAZIONE", new Registrazione()));
        LOGGER.debug(" Item: {}",  listMenu.get(count));

        listMenu.put(++count, new Iitem("CONFIGURAZIONE", new Configurazione()));
        LOGGER.debug(" Item: {}",  listMenu.get(count));

    }

    public static Menu1 getInstance() {
        if (null == instance) {
            instance = new Menu1();
        }
        LOGGER.debug(" Instanza: {}, ", instance);
        return instance;

    }

}