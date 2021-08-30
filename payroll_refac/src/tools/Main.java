package tools;

import patterns.Menu;
import patterns.Singleton;

public class Main {

    public static void main(String[] args)
    {
        Menu myMenu = Singleton.getMyMenu();
        myMenu.instaceOfMenu();
    }
}