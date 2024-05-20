package pages.cartpage;

import core.basepage.WebPage;

import static urls.Urls.CART_PAGE;

public class CartPage extends WebPage<CartPageMap, CartPageAssertions> {

    @Override
    protected String Url() {
        return CART_PAGE;
    }

    public void updateQuantity(String product) {
        elements().typeText(elements().updateQuantityField(), product);
        //elements().updateQuantityField().clear();
        //elements().updateQuantityField().sendKeys(product);
        elements().updateQuantityButton().click();
        elements().waitForAjax();
    }

    public void removeProductFromCart() {
        elements().waitForAjax();
        elements().removeButton().click();
    }
}
