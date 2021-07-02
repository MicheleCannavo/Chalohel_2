package chalohel.database;

/**
 * The interface Database.
 */
public interface IORM {

  void create();

  /**
   * Read.
   */
  void select(Long id);

  /**
   * Update.
   */
  void update(Long id);

  /**
   * Delete.
   */
  void drop(Long id);

}