package website.pages.returnproductpage;

import core.basepage.WebPage;
import enums.ProductOpened;
import enums.ReasonType;
import website.pages.productpage.ProductDetails;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static core.driver.Driver.waitForAjax;
import static urls.Urls.RETURN_PRODUCT_PAGE;

public class ReturnProductPage extends WebPage<ReturnProductPageMap, ReturnProductPageAssertions> {

    @Override
    protected String Url() {
        return RETURN_PRODUCT_PAGE;
    }

    public void selectReasonType(ReasonType reasonType) {
        waitForAjax();
        elements().returnReasonInput(reasonType).click();
    }

    public void selectIsProductOpened(ProductOpened reasonId) {
        waitForAjax();
        elements().productOpenedInput(reasonId).click();
    }

    public void fillReturnProductForm(ProductDetails product) {
        elements().typeText(elements().orderIdInput(), String.valueOf(product.getId()));
        elements().typeText(elements().orderDateInput(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        elements().typeText(elements().productNameInput(), product.getName());
        elements().typeText(elements().productCodeInput(), product.getModel());
        elements().typeText(elements().productQuantityInput(), product.getQuantity());
        selectReasonType(ReasonType.DEAD_ON_ARRIVAL);
        selectIsProductOpened(ProductOpened.YES);
        elements().submitButton().click();
    }
}