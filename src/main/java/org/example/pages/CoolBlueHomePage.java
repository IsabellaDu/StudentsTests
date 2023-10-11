package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.utils.WaitUtils.waitUntilElementIsVisible;

public class CoolBlueHomePage extends BasePage {
    private final String HOME_PAGE_URL = "https://www.coolblue.nl/en";
    @Getter
    @FindBy(xpath = "//ul[@class='hide@sm-down inline-list']//a[@href='/en/stores']")
    private WebElement elStoresCta;

    @Getter
    @FindBy(xpath = "//div[@class='pb--2 pb--0@sm section--4 section--6@sm']//button[@class='button button--order button--full-width']")
    private WebElement elCookiesNotificationCta;

    @Getter
    @FindBy(xpath = "//input[@id='search_query']")
    private WebElement elSearchItemInput;

    @Getter
    @FindBy(xpath = "//div[@class='content-card-from-size-m']//div[@class='section--6'][1]")
    private WebElement elTryAgainText;

    public CoolBlueHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(HOME_PAGE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(driver, elStoresCta);
    }
}
