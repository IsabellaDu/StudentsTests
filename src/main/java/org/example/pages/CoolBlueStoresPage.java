package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.utils.WaitUtils.waitUntilElementIsVisible;

public class CoolBlueStoresPage extends BasePage {
    private final String STORES_PAGE_URL = "https://www.coolblue.nl/en/stores";

    @FindBy(xpath = "//div[@class='section--2@sm']//h1")
    private WebElement elTitle;

    @FindBy(xpath = "//div[@class='section grid gap--3']//div[@class='text--truncate']")
    private List<WebElement> elsStoresAddressesList;

    public CoolBlueStoresPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(STORES_PAGE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(driver, elTitle);
    }

    public int getFullAmountOfStores() {
        return elsStoresAddressesList.size();
    }
}
