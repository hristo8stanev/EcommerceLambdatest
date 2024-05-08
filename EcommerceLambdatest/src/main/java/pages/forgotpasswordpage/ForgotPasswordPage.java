package pages.forgotpasswordpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.FORGOTTEN_PASSWORD_PAGE;

public class ForgotPasswordPage extends WebPage {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver, FORGOTTEN_PASSWORD_PAGE);
    }

    @Override
    protected String Url() {
        return FORGOTTEN_PASSWORD_PAGE
                ;
    }
}
