package pages.productpage;

import core.basepage.WebPage;
import enums.DifferentSizeType;
import pages.registerpage.PersonalInformation;

import static constants.Constants.REVIEW_STAR;
import static factories.CustomerFactory.faker;
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

    public void writeReview(PersonalInformation user) {
        elements().scrollToVisible(elements().addToCartButton());
        elements().starFormCheck(REVIEW_STAR).click();
        elements().typeText(elements().yourNameReviewInput(), user.firstName);
        elements().typeText(elements().yourReviewInput(), user.yourReview);
        elements().writeReviewButton().click();
        elements().reviewSection().click();
    }
}