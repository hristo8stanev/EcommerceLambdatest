package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

public class SearchPageTests extends BaseTest {

    @Test
    public void search(){
        webSite.searchPage.navigate();
        webSite.searchPage.assertUrlPage();
    }
}
