package pages.registerpage;

import core.basepage.WebPage;

import static urls.Urls.REGISTER_PAGE;

public class RegisterPage extends WebPage<RegisterPageMap, RegisterPageAssertions> {

    @Override
    protected String Url() {
        return REGISTER_PAGE;
    }


    public void method() {
        elements().firstNameInput().click();
    }
}