package pages.cartpage;

import core.basepage.WebPage;
import pages.productpage.ProductDetails;

import java.time.Duration;

import static core.driver.Driver.*;

import static urls.Urls.CART_PAGE;

public class CartPage extends WebPage<CartPageMap, CartPageAssertions> {

    @Override
    protected String Url() {
        return CART_PAGE;
    }

    public void updateQuantity(String product) {
        elements().typeText(elements().updateQuantityField(), product);
        elements().updateQuantityButton().click();
        waitForAjax();
    }

    public void removeProductFromCart() {
        elements().scrollToVisible(elements().shoppingCartAmount());

        while (Integer.parseInt(elements().shoppingCartAmount().getText()) > Integer.parseInt("1")) {
            elements().scrollToVisible(elements().removeButton());
            elements().removeButton().click();
            waitForAjax();
        }
    }
}