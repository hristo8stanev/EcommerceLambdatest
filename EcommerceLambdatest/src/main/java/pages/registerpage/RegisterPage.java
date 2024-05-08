package pages.registerpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.REGISTER_PAGE;

public class RegisterPage extends WebPage {

    public RegisterPage(WebDriver driver) {
        super(driver, REGISTER_PAGE);
    }

    @Override
    protected String Url() {
        return REGISTER_PAGE;
    }
}