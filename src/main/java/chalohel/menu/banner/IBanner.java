package chalohel.menu.banner;

import chalohel.utility.console.Output;

/**
 *
 */
public interface IBanner {

  /**
   *
   * @return
   */
  String getBanner() ;

  /**
   *
   */
  public default void printBanner(){
    Output.printnlLine(this.getBanner());
  }
}
