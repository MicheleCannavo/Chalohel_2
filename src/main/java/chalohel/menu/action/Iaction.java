package chalohel.menu.action;

/**
 * Interface to the classes that regulate
 * the various actions taken by the menu items.
 *
 * It needs the implementation of the run() method,
 * which is the method that performs the requested action,
 * and a name to be associated for the aforementioned action.
 */
public interface Iaction {

  /**
   * This method is for implementing the required action.
   */
  void run() ;

  /**
   * Returns the name associated with the action.
   * It should be unique.
   *
   * @return the name action.
   */
  String getNameAction();
}
