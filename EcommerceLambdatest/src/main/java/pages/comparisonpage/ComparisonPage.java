package pages.comparisonpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.COMPARISON_PAGE;

public class ComparisonPage extends WebPage {

    public ComparisonPage(WebDriver driver) {
        super(driver, COMPARISON_PAGE);
    }

    @Override
    protected String Url() {
        return COMPARISON_PAGE;
    }
}
