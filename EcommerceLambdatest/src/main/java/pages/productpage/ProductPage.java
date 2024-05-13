package pages.productpage;

import core.basepage.WebPage;

import static urls.Urls.SEARCH_SHOP_PRODUCTS_PAGE;

public class ProductPage extends WebPage<ProductPageMap, ProductPageAssertions> {

    @Override
    protected String Url() {
        return SEARCH_SHOP_PRODUCTS_PAGE;
    }

    public void method() {
        elements().compareButton().click();
        elements().proceedToCompare().sendKeys("asdada");
    }

}
