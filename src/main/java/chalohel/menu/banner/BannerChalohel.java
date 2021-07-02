package chalohel.menu.banner;

/**
 * The type banner.
 */
public class BannerChalohel implements IBanner {

  private static BannerChalohel instance = null;

  /* */
  private BannerChalohel() {
  }

  /**
   * @return
   */
  public static synchronized BannerChalohel getInstance() {
    if (null == instance) {
      instance = new BannerChalohel();
    }
    return instance;
  }

  /**
   * Gets banner.
   */
  public String getBanner() {

    return "***********************************************************" + System.lineSeparator() +
    "*      ___  _               __            __  __      _   *"        + System.lineSeparator() +
    "*     / __\\| |__    __ _   / /    ___    / / / / ___ | |  *"       + System.lineSeparator() +
    "*    / /   | '_ \\  / _` | / /    / _ \\  / /_/ / / _ \\| |  *"     + System.lineSeparator() +
    "*   / /___ | | | || (_| |/ /___ | (_) |/ __  / |  __/| |  *"        + System.lineSeparator() +
    "*   \\____/ |_| |_| \\__,_|\\____/  \\___/ \\/ /_/   \\___||_|  *"  + System.lineSeparator() +
    "***********************************************************"        ;

  }

}