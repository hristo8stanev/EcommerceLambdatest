package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.EMAIL_ADDRESS;
import static constants.Constants.PASSWORD;
import static factories.ProductsFactory.AppleProduct;

public class ProductPageTests extends BaseTest {

    @Test
    public void selectDifferentSizeOfProduct_When_DifferentSizeOfProductsSelected() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.mainHeader.addProductToCard(AppleProduct());
        webSite.productPage.selectMediumSizeType();
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();
        webSite.productPage.assertions().assertSizeProductIsCorrect(AppleProduct());
    }

    @Test
    public void selectDifferentSizeProduct_When_DifferentSizeProductSelectedAsNonAuthenticatedUser() {
        webSite.loginPage.navigate();
        webSite.mainHeader.addProductToCard(AppleProduct());
        webSite.productPage.selectMediumSizeType();
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();
        webSite.productPage.assertions().assertSizeProductIsCorrect(AppleProduct());
    }
}