package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

public class LoginPageTests extends BaseTest {

    @Test
    public void logintest(){
        webSite.loginPage.navigate();
    }
}
