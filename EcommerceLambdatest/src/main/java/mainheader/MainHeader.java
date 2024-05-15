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

    public void addProductToCard(ProductDetails product){
        searchProductByName(product);
        elements().findProduct().click();
        elements().quantityInput().clear();
        elements().quantityInput().sendKeys(product.quantity);
        elements().addToCartButton().click();
        elements().waitForAjax();
    }

    public void searchProductByName(ProductDetails productDetails){
        elements().searchField().clear();
        elements().searchField().sendKeys(productDetails.name);
        elements().waitForAjax();
        elements().searchButton().click();
    }
}
