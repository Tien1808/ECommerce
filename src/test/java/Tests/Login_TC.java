package Tests;

import Actions.Manage_Login_Action;
import Commons.SetUp;
import org.testng.annotations.Test;

public class Login_TC {
    public static void setUp() {
        SetUp.setUp();
    }

    @Test
    public void TC_Manage_Login_06() {
        Manage_Login_Action.Login(SetUp.driver, SetUp.user.getUsername(), SetUp.user.getPassword());
    }

    public void downCrash() {
        SetUp.downCrash();
    }
}
