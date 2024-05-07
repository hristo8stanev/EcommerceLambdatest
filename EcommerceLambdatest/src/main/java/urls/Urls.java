package urls;

public class Urls {
    public static final String BASE_URL = "https://ecommerce-playground.lambdatest.io/";
    public static final String ROUTE_PREFIX = "index.php?route=";

    public static String routeUrl(String route) {
        return BASE_URL + ROUTE_PREFIX + route;
    }

    public static final String SEARCH_SHOP_PRODUCTS_PAGE = routeUrl("product/search&search=&limit=100");

    public static String SEARCH_SHOP_PRODUCTS_PAGE_PRICE_RANGE(String minPrice, String maxPrice) {
        return routeUrl("product/search&limit=100&mz_fp=" + minPrice + "p" + maxPrice);
    }

    public static final String RETURN_PRODUCT_PAGE = routeUrl("account/return/add");
    public static final String SUCCESSFUL_RETURN_PRODUCT_PAGE = routeUrl("account/return/success");
    public static final String HOME_PAGE = routeUrl("common/home");
    public static final String CART_PAGE = routeUrl("checkout/cart");
    public static final String CHECKOUT_PAGE = routeUrl("checkout/checkout");
    public static final String LOGIN_PAGE = routeUrl("account/login");
    public static final String REGISTER_PAGE = routeUrl("account/register");
    public static final String WISHLIST_PAGE = routeUrl("account/wishlist");
    public static final String COMPARISON_PAGE = routeUrl("product/compare");
    public static final String SUCCESSFUL_REGISTRATION_PAGE = routeUrl("account/success");
    public static final String FORGOTTEN_PASSWORD_PAGE = routeUrl("account/forgotten");
    public static final String LOGOUT_USER_PAGE = routeUrl("account/logout");
    public static final String ORDER_HISTORY_PAGE = routeUrl("account/order");
    public static final String ORDER_PAGE = routeUrl("account/order/info");
    public static final String ACCOUNT_PAGE = routeUrl("account/account");
    public static final String VOUCHER_PAGE = routeUrl("account/voucher");
    public static final String SUCCESSFUL_VOUCHER_PAGE = routeUrl("account/voucher/success");
    public static final String ADDRESS_BOOK_PAGE = routeUrl("account/address");
    public static final String NEW_ADDRESS_PAGE = routeUrl("account/address/add");
    public static final String SUCCESSFUL_ORDER_PAGE = routeUrl("checkout/success");
}