package core.basepage;

import core.baseassertions.BaseAssertions;
import core.basemap.BaseMap;
import core.driver.Driver;
import core.newistance.NewInstance;
import org.junit.jupiter.api.Assertions;

import java.text.NumberFormat;
import java.util.Locale;

import static constants.Constants.ERROR_MESSAGE_URL;

public abstract class WebPage<ElementsT extends BaseMap, AssertionsT extends BaseAssertions<ElementsT>> {

    public String url;

    protected abstract String Url();

    public void navigate() {
        Driver.getBrowser().navigate().to(Url());
    }

    protected ElementsT elements() {
        return NewInstance.createByTypeParameter(getClass(), 0);
    }

    public AssertionsT assertions() {
        return NewInstance.createByTypeParameter(getClass(), 1);
    }

    public static NumberFormat getNumberFormat() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return currencyFormat;
    }

    public void assertUrlPage() {
        Assertions.assertEquals(Url(), Driver.getCurrentUrl(), ERROR_MESSAGE_URL);
        elements().waitForAjax();
    }
}