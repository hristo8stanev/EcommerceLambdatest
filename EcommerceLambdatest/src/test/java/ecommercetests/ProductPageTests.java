package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

public class ProductPageTests extends BaseTest {

    @Test
    public void product() {
        webSite.productPage.navigate();
        webSite.productPage.assertUrlPage();
    }
}
