/*
import menus.Menu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Menus {
    Menu menu1 = new Menu("CHALOHEL");
    Menu menu2 = new Menu("accessMenu");
    Menu menu3 = new Menu("projectMenu");
    Menu menu4 = new Menu("TrackerMenu");
    static Menus m = null;

    Map<Integer,Menu> listMenu = new HashMap<>();


    private Menus(){
        listMenu.put(1,menu1);
        listMenu.put(2,menu2);
        listMenu.put(3,menu3);
        listMenu.put(4,menu4);
    }

    public static Menus getMenus(){
        if(m==null)
            m = new Menus();
        return m;
    }

    private void setMenu1(){
        menu1.addItem("LOGIN",null);
        menu1.addItem("REGISTRAZIONE",null);
        menu1.addItem("CONFIGURAZIONE",null);
    }

    private void setMenu2(){

        menu2.addItem("NEW PROJECT",null);
        menu2.addItem("LOAD PROJECT",null);
        menu2.addItem("LOGOUT",null);
    }

    public String getMenu1 () {
        setMenu1();
        return menu1.toString();
    }

    public String getMenu2 () {
        setMenu2();
        clrscr();
        return menu2.toString();
    }

    public void runAction(int intChoose){

        listMenu.get(intChoose).getAction(intChoose);
    }

}*/