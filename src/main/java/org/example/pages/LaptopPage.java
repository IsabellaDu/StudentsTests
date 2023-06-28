package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.utils.WaitUtils.waitUntilElementIsVisible;

public class LaptopPage extends BasePage {

    private final String LAPTOP_PAGE_URL = "https://pn.com.ua/ct/1003/";

    @FindBy(xpath = "//ul[@class='breadcrumb']//descendant::li[5]/h1/span")
    private WebElement elLastTitleBreadcrumb;
    @FindBy(xpath = "//ul[@class='breadcrumb']//li//a[@href='/ct/1003/']//span")
    private WebElement elLaptopTitleBreadcrumb;

    @FindBy(xpath = "//div[@class='filter-block-body']//a[@href='/ct/1003/?fo=282']")
    private WebElement elDellCta;

    @FindBy(xpath = "//div[@class='catalog-block-head']//a")
    private List<WebElement> elsItemTitleList;


    public LaptopPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(LAPTOP_PAGE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(driver, elLastTitleBreadcrumb);
    }
}
