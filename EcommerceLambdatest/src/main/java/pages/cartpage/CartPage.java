package pages.cartpage;

import core.basepage.WebPage;

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
        waitForAjax();
        elements().removeButton().click();
    }
}
