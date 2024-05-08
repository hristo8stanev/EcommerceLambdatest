package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

public class CartPageTests extends BaseTest {

    @Test
    public void cartTest(){
        webSite.cartPage.navigate();
    }

}
