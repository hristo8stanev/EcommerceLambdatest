package constants;


import java.util.Random;

import static websitedata.factories.CustomerFactory.faker;

public class Constants {
    static Random ran = new Random();
    public static final String EMAIL_ADDRESS = "qatest@gmail.com";
    public static final String PASSWORD = "tester";
    public static final String SUCCESSFULLY_PURCHASE_MESSAGE = "Your order has been placed!";
    public static final String INVALID_EMAIL = faker.internet().emailAddress();
    public static final String INVALID_PASSWORD = faker.internet().password();
    public static final String MIN_PRICE = "10";
    public static final String MAX_PRICE = "1000";
    public static final String UPDATE_QUANTITY = String.valueOf(ran.nextInt(2) + 3);
    public static final String UNDER_THE_MINIMUM = String.valueOf(ran.nextInt(1) + 1);
    public static final String ERROR_MESSAGE_PRODUCT = "This product is not exist";
    public static final String ERROR_MESSAGE_PAGE = "This pade doesn't exist! Try again!";
    public static final String ERROR_MESSAGE_REVIEW = "Your review message is not correct, please try again";
    public static final String ERROR_MESSAGE_PRICE = "Total price does not match the expected value.";
    public static final String ERROR_MESSAGE_AGREE_TERMS = "Warning: You must agree to the Terms & Conditions!\n×";
    public static final String ERROR_MESSAGE_PRIVACY_POLICY = "Warning: You must agree to the Privacy Policy!";
    public static final String ERROR_MESSAGE_ORDER = "Your order hasn't been placed successfully";
    public static final String ERROR_MESSAGE_LOGOUT_BUTTON = "Logout button is not displayed";
    public static final String SUBTOTAL_PRICE_MESSAGE = "The subtotal price does not match.";
    public static final String EXPECTED_MESSAGE_FOR_CONFIRMATION_EMAIL = " An email with a confirmation link has been sent your email address.";
    public static final String EXPECTED_MESSAGE_FOR_INVALID_EMAIL = " Warning: The E-Mail Address was not found in our records, please try again!";
    public static final String ERROR_MESSAGE_CONFIRMATION_EMAIL = "Your email address is not correct";
    public static final String THE_WEB_DRIVER_BROWSER_INSTANCE_WAS_NOT_INITIALIZED_YOU_SHOULD_FIRST_CALL_THE_START_METHOD = "The WebDriver browser instance was not initialized. You should first call the start() method.";
    public static final String EXPECTED_MESSAGE_ACCOUNT_LOGOUT = "Account Logout";
    public static final String UNSUPPORTED_BROWSER_TYPE = "Unsupported browser type: ";
    public static final String YOUR_SHOPPING_CART_IS_EMPTY = "Your shopping cart is empty!";
    public static final String EXPECTED_MESSAGE_WRONG_CREDENTIALS = "Warning: No match for E-Mail Address and/or Password.";
    public static final String ERROR_MESSAGE_DATE = "The expected Date are not correct";
    public static final String ERROR_MESSAGE_PASSWORD = "Your Password hasn't been successfully updated";
    public static final String ERROR_MESSAGE_ADDRESS = "Your address hasn't been successfully added";
    public static final String SUCCESSFULLY_PURCHASE_VOUCHER_MESSAGE = "Purchase a Gift Certificate";
    public static final String SUCCESSFULLY_PASSWORD_MESSAGE = "Success: Your password has been successfully updated.";
    public static final String SUCCESSFULLY_ACCOUNT_INFORMATION_UPDATED_MESSAGE = "Success: Your account has been successfully updated.";
    public static final String SUCCESSFULLY_ADDED_NEW_ADDRESS_MESSAGE = "Your address has been successfully added";
    public static final String ERROR_MESSAGE_PRODUCT_INFORMATION = "The expected information about the product is not correct";
    public static final String ERROR_MESSAGE_PRODUCT_NAME = "The expected information about the name is not correct";
    public static final String ERROR_MESSAGE_PRODUCT_MODEL = "The expected information about the model is not correct";
    public static final String ERROR_MESSAGE_PRODUCT_PRICE = "The expected information about the price is not correct";
    public static final String ERROR_MESSAGE_PRODUCT_BRAND = "The expected information about the product brand is not correct";
    public static final String ERROR_MESSAGE_PRODUCT_AVAILABILITY = "The expected information about the product availability is not correct";
    public static final String SUCCESSFULLY_LOGIN = "Your Account Has Been Created!";
    public static final String ERROR_MESSAGE_EMPTY_FIRST_NAME = "First Name must be between 1 and 32 characters!";
    public static final String ERROR_MESSAGE_EMPTY_EMAIL_ADDRESS = "E-Mail Address does not appear to be valid!";
    public static final String ERROR_MESSAGE_EMPTY_PASSWORD = "Password must be between 4 and 20 characters!";
    public static final String EXPECTED_MESSAGE_NON_EXISTING_PRODUCT = "There is no product that matches the search criteria.";
    public static final String ERROR_MESSAGE_URL = "Expected page was not navigated.";
    public static final String ERROR_MESSAGE_RETURNS = "Your return request are not submitting.Try Again";
    public static final String PRODUCT_RETURNS_MESSAGE = "Thank you for submitting your return request. Your request has been sent to the relevant department for processing.";
    public static final String REVIEW_MESSAGE_FOR_APPROVAL = "Thank you for your review. It has been submitted to the webmaster for approval.";
    public static final String ERROR_MESSAGE_MINIMUM_AMOUNT = "Minimum order amount for Apple Cinema 30\" is 2!\n×";
}