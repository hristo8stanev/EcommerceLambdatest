package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

public class MyAccountPageTests extends BaseTest {

    @Test
    public void myAccount(){
        webSite.myAccountPage.navigate();

    }
}
