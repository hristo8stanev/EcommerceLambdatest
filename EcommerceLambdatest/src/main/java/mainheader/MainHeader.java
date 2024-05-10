package mainheader;

import org.openqa.selenium.WebDriver;
import core.basepage.WebPage;
import pages.productpage.ProductDetails;

import static urls.Urls.HOME_PAGE;

public class MainHeader extends WebPage {

    public MainHeader(WebDriver webDriver) {
        super(webDriver, HOME_PAGE);
    }

    @Override
    protected String Url() {
        return HOME_PAGE;
    }

    public void AddProductToCardt(ProductDetails product){

    }

    public void searchProductByName(ProductDetails productDetails){
        waitForAjax();

    }
}
