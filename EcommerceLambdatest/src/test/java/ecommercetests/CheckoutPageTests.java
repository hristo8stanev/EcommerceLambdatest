package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

public class CheckoutPageTests extends BaseTest {

    @Test
    public void checkout(){
        webSite.checkoutPage.navigate();

    }
}
