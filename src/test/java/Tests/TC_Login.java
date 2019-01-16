package Tests;

import Actions.Manage_Login_Action;
import Commons.SetUp_AlphaVersion;
import org.testng.annotations.Test;

public class TC_Login extends SetUp_AlphaVersion{
    @Test
    public void TC_Manage_Login_06() {
        Manage_Login_Action.Login(driver, initializeUser().getUsername(), initializeUser().getPassword());
    }
}
