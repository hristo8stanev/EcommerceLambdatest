package mainheader;

import core.basepage.WebPage;
import pages.productpage.ProductDetails;
import static core.driver.Driver.*;

import static urls.Urls.HOME_PAGE;

public class MainHeader extends WebPage<MainHeaderMap, MainHeaderAssertions> {

    @Override
    protected String Url() {
        return HOME_PAGE;
    }

    public void addProductToCard(ProductDetails product) {
        searchProductByName(product);
        elements().findProduct(product.id).click();
        elements().typeText(elements().quantityInput(), product.quantity);
        elements().addToCartButton().click();
        waitForAjax();
    }

    public void searchProductByName(ProductDetails productDetails) {
        elements().typeText(elements().searchField(), productDetails.name);
        waitForAjax();
        elements().searchButton().click();
    }
}