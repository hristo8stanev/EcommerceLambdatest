package website.pages.comparisonpage;

import core.basepage.WebPage;
import website.pages.productpage.ProductDetails;

import static core.driver.Driver.*;

import static urls.Urls.COMPARISON_PAGE;

public class ComparisonPage extends WebPage<ComparisonPageMap, ComparisonPageAssertions> {

    @Override
    protected String Url() {
        return COMPARISON_PAGE;
    }

    public void removeProductsById(ProductDetails... productIds) {
        for (ProductDetails productId : productIds) {
            elements().scrollToVisible(elements().findRemoveLinkById(productId));
            elements().findRemoveLinkById(productId).click();
            waitForAjax();
        }
    }
}