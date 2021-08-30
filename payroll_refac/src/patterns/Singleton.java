package patterns;

public class Singleton {
    private static Menu myMenu;

    public static Menu getMyMenu() {
        return myMenu = new Menu();
    }
}
