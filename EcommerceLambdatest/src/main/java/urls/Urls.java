package urls;

public class Urls {
    public static String BASE_URL = "https://ecommerce-playground.lambdatest.io/";
    public static String ROUTE_PREFIX = "index.php?route=";

    public static String routeUrl(String route) {
        return BASE_URL + ROUTE_PREFIX + route;
    }

    public static String SEARCH_SHOP_PRODUCTS_PAGE = routeUrl("product/search&search=&limit=100");

    public static String SEARCH_SHOP_PRODUCTS_PAGE_PRICE_RANGE(String minPrice, String maxPrice) {
        return routeUrl("product/search&limit=100&mz_fp=" + minPrice + "p" + maxPrice);
    }

    public static String BLOG_ARTICLE_PAGE = routeUrl("extension/maza/blog/home");
    public static String SPECIAL_PRODUCT_PAGE = routeUrl("product/special");
    public static String RETURN_PRODUCT_PAGE = routeUrl("account/return/add");
    public static String SUCCESSFUL_RETURN_PRODUCT_PAGE = routeUrl("account/return/success");
    public static String HOME_PAGE = routeUrl("common/home");
    public static String CART_PAGE = routeUrl("checkout/cart");
    public static String CHECKOUT_PAGE = routeUrl("checkout/checkout");
    public static String LOGIN_PAGE = routeUrl("account/login");
    public static String REGISTER_PAGE = routeUrl("account/register");
    public static String WISHLIST_PAGE = routeUrl("account/wishlist");
    public static String COMPARISON_PAGE = routeUrl("product/compare");
    public static String SUCCESSFUL_REGISTRATION_PAGE = routeUrl("account/success");
    public static String FORGOTTEN_PASSWORD_PAGE = routeUrl("account/forgotten");
    public static String LOGOUT_USER_PAGE = routeUrl("account/logout");
    public static String ORDER_HISTORY_PAGE = routeUrl("account/order");
    public static String ORDER_PAGE = routeUrl("account/order/info");
    public static String ACCOUNT_PAGE = routeUrl("account/account");
    public static String VOUCHER_PAGE = routeUrl("account/voucher");
    public static String SUCCESSFUL_VOUCHER_PAGE = routeUrl("account/voucher/success");
    public static String ADDRESS_BOOK_PAGE = routeUrl("account/address");
    public static String NEW_ADDRESS_PAGE = routeUrl("account/address/add");
    public static String SUCCESSFUL_ORDER_PAGE = routeUrl("checkout/success");
}