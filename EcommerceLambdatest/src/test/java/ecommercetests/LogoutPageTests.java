package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

public class LogoutPageTests extends BaseTest {

    @Test
    public void logout(){
        webSite.logoutPage.navigate();

    }

}
