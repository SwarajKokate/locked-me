import screens.MainScreen;
import util.HandleMenuOptions;

/**
 * @author Swaraj Kokate
 */
public class LockedMeApplication {

    public static void main(String[] args) {
        MainScreen.printWelcomeScreen();
        HandleMenuOptions.handleWelcomeScreenInput();
    }

}
