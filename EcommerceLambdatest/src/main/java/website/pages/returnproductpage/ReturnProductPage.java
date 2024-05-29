package website.pages.returnproductpage;

import core.basepage.WebPage;
import enums.ProductOpened;
import enums.ReasonType;
import website.pages.productpage.ProductDetails;

import static Utils.LocalDateTime.LocalDate.*;
import static core.driver.Driver.*;
import static urls.Urls.*;

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

    public void fillReturnProductForm(ProductDetails product, ReasonType reasonType, ProductOpened productOpened) {
        elements().typeText(elements().orderIdInput(), String.valueOf(product.getId()));
        elements().typeText(elements().orderDateInput(), getDate());
        elements().typeText(elements().productNameInput(), product.getName());
        elements().typeText(elements().productCodeInput(), product.getModel());
        elements().typeText(elements().productQuantityInput(), product.getQuantity());
        selectReasonType(reasonType);
        selectIsProductOpened(productOpened);
        elements().submitButton().click();
    }

}
