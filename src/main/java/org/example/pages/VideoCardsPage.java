package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static org.example.utils.WaitUtils.waitUntilElementIsVisible;

public class VideoCardsPage extends BasePage {

    private final String VIDEO_CARD_PAGE_URL = "https://pn.com.ua/ct/1047/";
    @Getter
    @FindBy(xpath = "//ul[@class='breadcrumb']//li[4]//h1/span")
    private WebElement elTitle;
    @Getter
    @FindBy(xpath = "//div[@class='filter-block-body']//a[@data-id='282']")
    private WebElement elDellCta;

    @FindBy(xpath = "//article[@class='item td-table']//div[@class='catalog-block-head']/a")
    private List<WebElement> elsTitleOfArticleList;

    public VideoCardsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(VIDEO_CARD_PAGE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(driver, elTitle);
    }

    private boolean doesTitleContainSomeText(String title, String someText) {
        return title.toLowerCase().contains(someText.toLowerCase());
    }

    public void checkDoesEveryTitleOfArticleContainDell() {
        waitUntilElementIsVisible(driver, elsTitleOfArticleList.get(0));
        for (WebElement element : elsTitleOfArticleList) {
            waitUntilElementIsVisible(driver, element);
            Assert.assertTrue(doesTitleContainSomeText(element.getText(), "Dell"),
                    String.format("current element doesn't contain the name of company (Dell): %s", element.getText()));
        }
    }
}
