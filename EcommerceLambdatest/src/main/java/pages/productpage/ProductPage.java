package pages.productpage;

import core.basepage.WebPage;
import enums.DifferentSizeType;

import static urls.Urls.SEARCH_SHOP_PRODUCTS_PAGE;

public class ProductPage extends WebPage<ProductPageMap, ProductPageAssertions> {

    @Override
    protected String Url() {
        return SEARCH_SHOP_PRODUCTS_PAGE;
    }

    public void selectSize(DifferentSizeType sizeType)
    {
        switch (sizeType)
        {
            case DifferentSizeType.SMALL:
                elements().smallSize().click();
                break;

            case DifferentSizeType.MEDIUM:
                elements().mediumSize().click();
                break;

            case DifferentSizeType.LARGE:
                elements().largeSize().click();
                break;

            default:
                throw new IllegalArgumentException("Unsupported size type: " + sizeType);
        }
    }

    public void selectSmallSizeType() {
        selectSize(DifferentSizeType.SMALL);
    }
    public void selectMediumSizeType() {
        selectSize(DifferentSizeType.MEDIUM);
    }
    public void selectLargeSizeType() {
        selectSize(DifferentSizeType.LARGE);
    }
}
