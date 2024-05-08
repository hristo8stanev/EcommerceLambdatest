package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

public class ProductPageTests extends BaseTest {

    @Test
    public void registerWithValidCredentialsTest() {
        webSite.productPage.navigate();
        webSite.productPage.assertUrlPage();
    }
}
