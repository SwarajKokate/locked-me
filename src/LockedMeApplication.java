import screens.MenuOptions;
import util.HandleMenuOptions;

/**
 * @author Swaraj Kokate
 */
public class LockedMeApplication {

    public static void main(String[] args) {
        MenuOptions.printWelcomeScreen();
        HandleMenuOptions.handleWelcomeScreenInput();
    }

}
