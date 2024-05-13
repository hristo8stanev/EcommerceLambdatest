package pages.checkoutpage;

import org.openqa.selenium.WebDriver;
import core.basepage.WebPage;

import static urls.Urls.CHECKOUT_PAGE;

public class CheckoutPage extends WebPage<CheckoutPageMap,CheckoutPageAssertions> {

    @Override
    protected String Url() {
        return CHECKOUT_PAGE;
    }

    public void method()
    {
        elements().agreeTerms().click();
        elements().addressField1().sendKeys("sadsa");
    }
}
