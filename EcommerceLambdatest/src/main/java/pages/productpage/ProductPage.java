package pages.productpage;

import core.basepage.WebPage;
import enums.DifferentSizeType;

import static urls.Urls.SEARCH_SHOP_PRODUCTS_PAGE;

public class ProductPage extends WebPage<ProductPageMap, ProductPageAssertions> {

    @Override
    protected String Url() {
        return SEARCH_SHOP_PRODUCTS_PAGE;
    }

    public void selectSize(DifferentSizeType sizeType) {
        elements().selectSize(sizeType).click();
    }

    public void selectSmallSizeType() {
        selectSize(DifferentSizeType.SMALL);
        elements().waitForAjax();
        elements().addToCartButton().click();
    }

    public void selectMediumSizeType() {
        selectSize(DifferentSizeType.MEDIUM);
        elements().waitForAjax();
        elements().addToCartButton().click();
    }

    public void selectLargeSizeType() {
        selectSize(DifferentSizeType.LARGE);
        elements().waitForAjax();
        elements().addToCartButton().click();
    }
}