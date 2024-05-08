package pages.returnproductpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.RETURN_PRODUCT_PAGE;

public class ReturnProductPage extends WebPage {

    public ReturnProductPage(WebDriver driver) {
        super(driver, RETURN_PRODUCT_PAGE);
    }

    @Override
    protected String Url() {
        return RETURN_PRODUCT_PAGE;
    }
}
