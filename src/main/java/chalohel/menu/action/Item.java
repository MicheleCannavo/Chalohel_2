package chalohel.menu.action;

/**
 * The type Item.
 */
public class Item {

  /* Name of the instance action */
  private final String label;

  /* Action type of the instance */
  private final Iaction action;

  /**
   * Instantiates a new Item.
   *
   * @param action the action
   */
  public Item( Iaction action) {
    this.label  = action.getNameAction();
    this.action = action;
  }

  /**
   *
   * @return
   */
  @Override
  public String toString() {
    return  label + " -> " + action.toString();
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
  public String getLabel() {
    return label;
  }
}