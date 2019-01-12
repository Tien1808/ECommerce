package Tests.Shopping_TC;

import Actions.Shopping_ManageBasket_Action;
import Commons.SetUp;
import org.testng.annotations.Test;

public class Shopping_ManageBasket_TC {

    public void setUp() {
        SetUp.setUp();
    }

    @Test
    public void TC_Shopping_ManageBasket_01() {
        // Call to method 'clickAddShoppingCartButton'.
        Shopping_ManageBasket_Action.clickAddShoppingCartButton(SetUp.driver);
        // Basket popup is displayed Verification point.
    }

    public void downCrash() {
        SetUp.downCrash();
    }
}
