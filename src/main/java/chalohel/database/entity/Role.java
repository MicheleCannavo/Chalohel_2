package chalohel.database.entity;

/**
 * The enum Role.
 */
public enum Role {

  /**
   * Dev role.
   */
  DEV(2),
  /**
   * Admin role.
   */
  ADMIN(1),
  /**
   * User role.
   */
  USER(0);

  private int levelAccess;

  /**
   * Sets level access.
   *
   */
  public void setLevelAccess() {
    setLevelAccess();
  }

  /**
   * Sets level access.
   *
   * @param levelAccess the level access
   */
  public void setLevelAccess( int levelAccess ) {
    this.levelAccess = levelAccess;
  }

  /**
   * Gets level access.
   *
   * @return the level access
   */
  public int getLevelAccess() {
    return levelAccess;
  }

  Role( int i ) {
  }

}