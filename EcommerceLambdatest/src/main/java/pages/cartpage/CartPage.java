package pages.cartpage;

import core.basepage.WebPage;

import static urls.Urls.CART_PAGE;

public class CartPage extends WebPage<CartPageMap, CartPageAssertions> {

    @Override
    protected String Url() {
        return CART_PAGE;
    }
}
