package pages.logoutpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogoutPageMap extends BaseMap {

    public WebElement logoutButton() {
        return waitAndFindElement(By.xpath("//div[@id='account-account']//a[contains(normalize-space(@href),'account/logout')]"));
    }
    public WebElement myAccountNavigationBarElement() {
        return waitAndFindElement(By.xpath("//ul[@class='navbar-nav horizontal']//a[contains(@href, 'account/account')]"));
    }
    public WebElement accountLogout() {
        return waitAndFindElement(By.xpath("//h1[@class='page-title my-3']"));
    }
}