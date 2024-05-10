package ecommercetests;

import core.BaseTest;
import core.driver.Driver;
import org.junit.jupiter.api.Test;

public class RegisterPageTests extends BaseTest {

    @Test
    public void registerWithValidCredentialsTest() {
        webSite.registerPage.navigate();
        webSite.registerPage.assertUrlPage();

        webSite.registerPage.method();


    }
}