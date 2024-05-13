package mainheader;

import org.openqa.selenium.WebDriver;
import core.basepage.WebPage;
import pages.productpage.ProductDetails;

import static urls.Urls.HOME_PAGE;

public class MainHeader extends WebPage<MainHeaderMap,MainHeaderAssertions> {

    @Override
    protected String Url() {
        return HOME_PAGE;
    }

    public void AddProductToCard(ProductDetails product){
        searchProductByName(product);
        elements().findProduct().click();
        elements().quantityInput().sendKeys(product.quantity);
        elements().addToCartButton().click();
    }

    public void searchProductByName(ProductDetails productDetails){
        elements().searchField().sendKeys(productDetails.name);
        //waitForAjax();
        elements().searchButton().click();
    }
}
