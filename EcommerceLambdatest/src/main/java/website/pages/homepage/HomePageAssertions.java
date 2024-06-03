package website.pages.homepage;

import core.baseassertions.BaseAssertions;
import enums.ShopCategory;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static constants.Constants.ERROR_MESSAGE_PAGE;
import static org.junit.jupiter.api.Assertions.assertAll;

public class HomePageAssertions extends BaseAssertions<HomePageMap> {

    public void assertCorrectCategoryDisplayed(ShopCategory shopCategory) {
        var expectedCategory = elementsT().categoryHeader().getText();
        Assertions.assertTrue(expectedCategory.contains(shopCategory.getCategory()));
    }

    public void assertSuccessfulRedirectToSpecialOfferPage() {
        var expectedResult = elementsT().specialOffersHeader().isDisplayed();
        Assertions.assertTrue(expectedResult, ERROR_MESSAGE_PAGE);
    }

    public void assertSuccessfulRedirectToBlogArticlePage() {
        var expectedResult = elementsT().latestArticles().isDisplayed();
        Assertions.assertTrue(expectedResult, ERROR_MESSAGE_PAGE);
    }

    private void assertEmailInputDisplayed() {
        var expectedEmailInput = elementsT().emailInput().isDisplayed();
        Assertions.assertTrue(expectedEmailInput, ERROR_MESSAGE_PAGE);
    }

    private void assertPasswordInputDisplayed() {
        var expectedPasswordInput = elementsT().passwordInput().isDisplayed();
        Assertions.assertTrue(expectedPasswordInput, ERROR_MESSAGE_PAGE);
    }

    private void assertLoginButtonDisplayed() {
        var expectedLoginButton = elementsT().loginButton().isDisplayed();
        Assertions.assertTrue(expectedLoginButton, ERROR_MESSAGE_PAGE);
    }

    public void assertSuccessfulLoginFormDisplayed() {
        assertAll(
                () -> assertEmailInputDisplayed(),
                () -> assertPasswordInputDisplayed(),
                () -> assertLoginButtonDisplayed()
        );
    }
}