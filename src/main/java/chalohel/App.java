package chalohel;

import chalohel.menu.banner.BannerChalohel;
import chalohel.menu.Choose.Choose;
import chalohel.menu.menustype.AbstractMenu;
import chalohel.menu.menustype.Menu1;
import chalohel.utility.console.Console;
import chalohel.utility.console.Output;

public class App {

    public static void main(String[] args) {

        Console.clrscr();
        BannerChalohel.getInstance().printBanner();
        AbstractMenu m1 = Menu1.getInstance();
        Console.clrscr();
        m1.printMenu();
        var ch1= new Choose("Scelta", m1.getNumberItems());
        ch1.requestChoose();
        Output.printnlLine("Number choose: %s ", ch1.getNumerChoose());
        m1.getAction(ch1.getNumerChoose());
    }
}