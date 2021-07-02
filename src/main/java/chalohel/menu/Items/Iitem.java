package chalohel.menu.Items;

import chalohel.menu.action.Iaction;

/**
 * The type Iitem.
 */
public class Iitem {

    private final String label;
    private Iaction action;

    /**
     * Instantiates a new Iitem.
     *
     * @param label  the label
     * @param action the action
     */
    public Iitem ( String label, Iaction action ) {
        this.label  = label;
        this.action = action;
    }

    @Override
    public String toString () {
        return  label+" -> "+action.toString() ;
    }

    /**
     * Gets action.
     *
     * @return the action
     */
    public Iaction getAction() {
        return action;
    }

    /**
     * Gets label.
     *
     * @return the label
     */
    public String getLabel () {
        return label;
    }
}
