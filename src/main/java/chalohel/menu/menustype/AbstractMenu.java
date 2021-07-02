package chalohel.menu.menustype;


import chalohel.menu.Items.Iitem;
import chalohel.utility.console.Console;
import chalohel.utility.console.Output;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * brief vj
 *
 *
 * The type Abstract menu.
 */
public class AbstractMenu {
    private static final Logger LOGGER  =
      LoggerFactory.getLogger(AbstractMenu.class);
    protected int count = 0;
    /**
     * The constant title.
     */
    protected static String title;

    /**
     * The constant listMenu.
     */
    protected static final Map<Integer, Iitem> listMenu = new HashMap<>();

    /**
     * The Length divisor.
     */
    protected int lengthDivisor = 40;


    /**
     * Print menu.
     */
    public void printMenu(){
        Output.printnlLine(this.toString());
    }

    @Override
    public String toString () {

        return "\n" +
                lineDivisor() +
                centerTitle() +
                lineDivisor() +
                createItemsMenu() +
                lineDivisor()  ;
    }


    /**
     * Center title string.
     *
     * @return the string
     */
    private String centerTitle () {
        int lSpace = (lengthDivisor - title.length() )/2 ;

        LOGGER.debug("Tot:{} - Title:{} - lSpace:{} ",
          lengthDivisor, title.length(), lSpace);

        return ((" ").repeat(lSpace))
                    .concat(title)
                    .concat(System.lineSeparator());
    }

    private String lineDivisor () {
        var divisore = "-";
        return divisore.repeat(lengthDivisor)+System.lineSeparator();
    }


    private String createItemsMenu () {
        var listItemsMenu = new StringBuilder();

        for (Map.Entry<Integer, Iitem> entry : listMenu.entrySet()) {
            listItemsMenu
                    .append(Console.getMyTab())
                    .append(entry.getKey())
                    .append(") ")
                    .append(entry.getValue().getLabel())
                    .append(System.lineSeparator());
        }
        return listItemsMenu.toString();
    }

    public int getNumberItems(){
        return count;
    }

    public void getAction(int numAction){
        Output.printnlLine(
          listMenu.get(numAction)
                  .getLabel());
    }
}