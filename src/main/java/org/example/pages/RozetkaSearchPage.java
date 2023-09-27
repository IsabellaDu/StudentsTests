package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static org.example.utils.WaitUtils.waitUntilElementIsClickable;
import static org.example.utils.WaitUtils.waitUntilElementIsVisible;

public class RozetkaSearchPage extends BasePage {

    private final String ROZETKA_SEARCH_PAGE_URL = "https://rozetka.com.ua/search/";
    @Getter
    @FindBy(xpath = "//rz-filter-stack[@class='ng-star-inserted']")
    private WebElement elSideBar;
    @FindBy(xpath = "//div[@data-filter-name='producer']//a[@class='checkbox-filter__link']")
    private List<WebElement> elsBrandList;

    @FindBy(xpath = "//a[@class='catalog-selection__link']")
    private List<WebElement> elsCatalogSelectionList;

    public RozetkaSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(ROZETKA_SEARCH_PAGE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(driver, elSideBar);
    }

    public int getFullAmountOfBrands() {
        return elsBrandList.size();
    }

    public void checkCatalogSelection() {
        waitUntilElementIsClickable(driver, elsBrandList.get(0));
        for (WebElement elBrand : elsBrandList) {
            waitUntilElementIsClickable(driver, elBrand);
            elBrand.click();
            waitUntilElementIsVisible(driver, elsCatalogSelectionList.get(0));
            boolean isAnyMatchInList = elsCatalogSelectionList.stream().anyMatch(x -> x.getText().contains(elBrand.getText()));
            Assert.assertTrue(isAnyMatchInList, "expected catalog selection is not displayed");
        }
    }
}
