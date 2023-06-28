import org.example.core.driver.WebDriverFactory;
import org.example.pages.HomePage;
import org.example.utils.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.utils.WaitUtils.waitUntilElementIsClickable;
import static org.example.utils.WaitUtils.waitUntilElementIsVisible;


public class TestRunner {
    public static void main(String[] args) {
        /*WebDriver driver = WebDriverFactory.getDriver();
        driver.get(ConfigProvider.getBASE_URL());

        WebElement elAllPriceTitle = driver.findElement(By.xpath("//div[@class='logo']//span[contains(text(), 'Все цены')]"));
        waitUntilElementIsVisible(driver, elAllPriceTitle);
        System.out.println("Title is visible");

        WebElement elHeadPhonesCta = driver.findElement(By.xpath("//div[@class='pc-block']//a[@title='Наушники']"));
        waitUntilElementIsClickable(driver, elHeadPhonesCta);
        elHeadPhonesCta.click();

        *//*WebElement elNewTitle = driver.findElement(By.xpath("//div[@class='article-block']//a[@href='/info/kak-vybrat-naushniki-69/']"));
        waitUntilElementIsClickable(driver, elNewTitle);
        elNewTitle.click();*//*
        driver.quit();*/

        WebDriver driver = WebDriverFactory.getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        waitUntilElementIsClickable(driver, homePage.getElHeadPhonesCta());
        homePage.getElHeadPhonesCta().click();
        driver.quit();
    }
}