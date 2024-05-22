package pages.productpage;

import core.basepage.WebPage;
import core.driver.Driver;
import enums.DifferentSizeType;
import pages.registerpage.PersonalInformation;
import static core.driver.Driver.*;

import static enums.ReviewStars.*;
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
        waitForAjax();
        elements().addToCartButton().click();
    }

    public void selectMediumSizeType() {
        selectSize(DifferentSizeType.MEDIUM);
        waitForAjax();
        elements().addToCartButton().click();
    }

    public void selectLargeSizeType() {
        selectSize(DifferentSizeType.LARGE);
        waitForAjax();
        elements().addToCartButton().click();
    }

    public void writeReview(PersonalInformation user) {
        elements().scrollToVisible(elements().addToCartButton());
        elements().starFormCheck(FIVE_STAR).click();
        elements().typeText(elements().yourNameReviewInput(), user.firstName);
        elements().typeText(elements().yourReviewInput(), user.yourReview);
        elements().writeReviewButton().click();
        elements().reviewSection().click();
    }
}