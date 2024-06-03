package website.pages.searchpage;

import core.basepage.WebPage;
import enums.Manufacturer;
import org.openqa.selenium.Keys;
import website.pages.productpage.ProductDetails;

import java.util.function.Function;

import static core.driver.Driver.*;

import static enums.Manufacturer.*;
import static urls.Urls.SEARCH_SHOP_PRODUCTS_PAGE;

public class SearchPage extends WebPage<SearchPageMap, SearchPageAssertions> {

    @Override
    protected String Url() {
        return SEARCH_SHOP_PRODUCTS_PAGE;
    }

    private void hoverToProduct(ProductDetails product) {
        elements().hover(elements().getProduct(product.getId()));
        waitForAjax();
    }

    public void searchProduct(ProductDetails product, Function<String, String> transform) {
        elements().typeText(elements().searchInput(), transform.apply(product.getName()));
        elements().searchButton().click();
    }

    public void searchProductByFullName(ProductDetails product) {
        searchProduct(product, name -> name);
    }

    public void searchProductByPartialName(ProductDetails product) {
        searchProduct(product, name -> name.substring(0, 3));
    }

    public void searchProductByLowerCaseOnlyName(ProductDetails product) {
        searchProduct(product, String::toLowerCase);
    }

    public void searchProductByUpperCaseOnlyName(ProductDetails product) {
        searchProduct(product, String::toUpperCase);
    }

    public void proceedToProduct(ProductDetails product) {
        elements().scrollToVisible(elements().getProduct(product.getId()));
        waitForAjax();
        elements().getProduct(product.getId()).click();
    }

    public void proceedToQuickView(ProductDetails product) {
        hoverToProduct(product);
        elements().quickViewButton(product).click();
    }

    public void addToCart(ProductDetails product) {
        hoverToProduct(product);
        elements().addToCart(product).click();
    }

    public void addToWishlist(ProductDetails productDetails) {
        hoverToProduct(productDetails);
        elements().addToWishlist(productDetails).click();
    }

    public void compareProducts(ProductDetails productDetails) {
        elements().hover(elements().getProduct(productDetails.getId()));
        elements().compareButton(productDetails).click();
        waitForAjax();
    }

    public void typeRangePrices(String min, String max) {
        elements().typeText(elements().minPriceField(), min);
        elements().typeText(elements().maxPriceField(), max);
        elements().maxPriceField().sendKeys(Keys.ENTER);
        waitForAjax();
    }

    public void sortedByManufacturer(Manufacturer manufacturer) {
        elements().scrollToVisible(elements().manufacturerPanel(manufacturer));
        elements().manufacturerPanel(manufacturer).click();
        waitForAjax();
        elements().waitUntilPageLoadsCompletely();
    }
}