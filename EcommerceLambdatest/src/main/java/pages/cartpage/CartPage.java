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
        elements().scrollToVisible(elements().shoppingCartAmount());

        while (isCartEmpty()) {
            clickOnFirstRemoveButton();
        }
    }

    public boolean isCartEmpty() {
        return !elements().shoppingCartAmount().getText().equals("0");
    }

    private void clickOnFirstRemoveButton() {
        elements().scrollToVisible(elements().removeButton());
        elements().removeButton().click();
        waitForAjax();
    }
}