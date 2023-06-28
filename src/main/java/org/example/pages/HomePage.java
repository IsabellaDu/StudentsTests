package org.example.pages;

import lombok.Getter;
import org.example.utils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.utils.WaitUtils.waitUntilElementIsVisible;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='logo']//span[contains(text(), 'Все цены')]")
    private WebElement elPageTitle;

    @Getter
    @FindBy(xpath = "//div[@class='pc-block']//a[@title='Наушники']")
    private WebElement elHeadPhonesCta;
    @Getter
    @FindBy(xpath = "//div[@class='pc-block']//a[@title='Ноутбуки']")
    private WebElement elLaptopCta;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(ConfigProvider.getBASE_URL());
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(super.driver, elPageTitle);
    }
}
