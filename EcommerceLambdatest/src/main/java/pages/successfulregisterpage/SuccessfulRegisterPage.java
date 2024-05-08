package pages.successfulregisterpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.SUCCESSFUL_REGISTRATION_PAGE;

public class SuccessfulRegisterPage extends WebPage {

    public SuccessfulRegisterPage(WebDriver driver) {
        super(driver, SUCCESSFUL_REGISTRATION_PAGE);
    }

    @Override
    protected String Url() {
        return SUCCESSFUL_REGISTRATION_PAGE;
    }
}
