package pages.successfulreturnproductpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.SUCCESSFUL_RETURN_PRODUCT_PAGE;

public class SuccessfulReturnProductPage extends WebPage {

    public SuccessfulReturnProductPage(WebDriver driver) {
        super(driver, SUCCESSFUL_RETURN_PRODUCT_PAGE );
    }

    @Override
    protected String Url() {
        return SUCCESSFUL_RETURN_PRODUCT_PAGE;
    }
}
