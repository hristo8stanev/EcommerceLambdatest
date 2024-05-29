package website.pages.productpage;

import core.basepage.WebPage;
import enums.Size;
import enums.ReviewStars;

import static core.driver.Driver.*;

import static urls.Urls.SEARCH_SHOP_PRODUCTS_PAGE;

public class ProductPage extends WebPage<ProductPageMap, ProductPageAssertions> {

    @Override
    protected String Url() {
        return SEARCH_SHOP_PRODUCTS_PAGE;
    }

    public void selectSize(Size sizeType) {
        elements().selectSize(sizeType).click();
    }

    public void selectSmallSizeType() {
        selectSize(Size.SMALL);
        waitForAjax();
        elements().addToCartButton().click();
    }

    public void selectMediumSizeType() {
        selectSize(Size.MEDIUM);
        waitForAjax();
        elements().addToCartButton().click();
    }

    public void selectLargeSizeType() {
        selectSize(Size.LARGE);
        waitForAjax();
        elements().addToCartButton().click();
    }

    public void writeReview(CommentDetails user) {
        elements().scrollToVisible(elements().addToCartButton());
        elements().starFormCheck(user.reviewStars).click();
        elements().typeText(elements().yourNameReviewInput(), user.userName);
        elements().typeText(elements().yourReviewInput(), user.yourReview);
        elements().writeReviewButton().click();
        elements().reviewSection().click();
    }
}