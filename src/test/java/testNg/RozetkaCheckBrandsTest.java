package testNg;

import org.example.core.data.DataProviderMethods;
import org.example.pages.HomePage;
import org.example.pages.RozetkaPage;
import org.example.pages.RozetkaSearchPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RozetkaCheckBrandsTest extends BaseTest {

    @Test(dataProvider = "dataForRozetkaBrandTest", dataProviderClass = DataProviderMethods.class)
    public void checkAmountOfBrands(String userRequest, int amountOfBrands) {
        RozetkaPage homePage = new RozetkaPage(driver);
        homePage.open();
        homePage.getElSearchInput().sendKeys(userRequest, Keys.ENTER);
        RozetkaSearchPage searchPage = new RozetkaSearchPage(driver);
        searchPage.ensureOpened();
        Assert.assertEquals(searchPage.getFullAmountOfBrands(), amountOfBrands,
                "expected amount of brands doesn't match actual amount");
        searchPage.checkCatalogSelection();
    }

    @Test
    public void checkCatalogSelection() {
        RozetkaPage homePage = new RozetkaPage(driver);
        homePage.open();
        homePage.getElSearchInput().sendKeys(" процессор", Keys.ENTER);
        RozetkaSearchPage searchPage = new RozetkaSearchPage(driver);
        searchPage.ensureOpened();
        searchPage.checkCatalogSelection();
    }

    @Test()
    public void canSearch(String userRequest) {
        HomePage homePage = new HomePage(driver);
        homePage.open();

       /* homePage.getElSearchInput().sendKeys(userRequest, Keys.ENTER);

        SearchPage searchPage = new SearchPage(driver);
        // Assert.assertEquals(searchPage.getElSearchTitle().getText(), "laptops");
        // Assert.assertEquals(searchPage.getElSearchTitle().text(), homePage.getElSearchInput().getAttribute("value"));

        Assert.assertTrue(doesItemsTextContainText(searchPage.getElSearchTitle().getText(), homePage.getElSearchInput().getAttribute("value")));*/
    }

    public boolean doesItemsTextContainText(String firstText, String secondText) {
        return firstText.toLowerCase().contains(secondText.toLowerCase());
    }

}
