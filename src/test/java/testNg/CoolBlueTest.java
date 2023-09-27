package testNg;

import org.example.pages.CoolBlueHomePage;
import org.example.pages.CoolBlueStoresPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CoolBlueTest extends BaseTest {
    @Test
    public void checkAmountOfArticles() {
        CoolBlueHomePage homePage = new CoolBlueHomePage(driver);
        homePage.open();
       // homePage.getElCookiesNotificationCta().click();
        homePage.getElStoresCta().click();
        CoolBlueStoresPage storesPage = new CoolBlueStoresPage(driver);
        storesPage.ensureOpened();
        Assert.assertEquals(storesPage.getFullAmountOfStores(), 14, "expected amount of stores doesn't match actual amount");
    }

}
