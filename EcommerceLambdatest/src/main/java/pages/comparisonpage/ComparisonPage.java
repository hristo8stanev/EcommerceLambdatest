package pages.comparisonpage;

import core.basepage.WebPage;

import static urls.Urls.COMPARISON_PAGE;

public class ComparisonPage extends WebPage<ComparisonPageMap,ComparisonPageAssertions> {

    @Override
    protected String Url() {
        return COMPARISON_PAGE;
    }

    public void compareProduct() {
        elements().scrollToVisible(elements().compareProductButton());
        elements().compareProductButton().click();
        elements().waitForAjax();
        elements().compareButton().click();
    }
}
