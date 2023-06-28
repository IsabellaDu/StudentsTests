package testNg;

import lombok.extern.log4j.Log4j2;
import org.example.pages.HomePage;
import org.example.pages.VideoCardsPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.utils.WaitUtils.waitUntilElementIsClickable;
import static org.example.utils.WaitUtils.waitUntilElementIsVisible;

@Log4j2
public class TestNgTest extends BaseTest {
    @Test
    public void openHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
    }

    @Test
    public void checkLaptopTitleIsCorrect() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        waitUntilElementIsVisible(driver, homePage.getElLaptopCta());
        if (homePage.getElLaptopCta().getText().equalsIgnoreCase("Ноутбуки2")) {
            log.info("INFO: title works correct: " + homePage.getElLaptopCta().getText());
        } else {
            log.error("Expected title doesn't match actual title: " + homePage.getElLaptopCta().getText());
        }
    }

    @Test
    public void checkIsLaptopHrefCorrect() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        waitUntilElementIsClickable(driver, homePage.getElLaptopCta());
        Assert.assertEquals(homePage.getElLaptopCta().getAttribute("href"),
                "https://pn.com.ua/ct/1003/", "expected href doesn't match actual href");
    }

    @Test
    public void checkIsVideoCardsTitleCorrect() {
        VideoCardsPage videoCardsPage = new VideoCardsPage(driver);
        videoCardsPage.open();
        waitUntilElementIsVisible(driver, videoCardsPage.getElTitle());
        Assert.assertEquals(videoCardsPage.getElTitle().getText(), "Видеокарты",
                "expected text on the title doesn't match actual text");
    }

    @Test
    public void checkDoesEveryTitleOfArticleHaveDell() throws InterruptedException {
        VideoCardsPage videoCardsPage = new VideoCardsPage(driver);
        videoCardsPage.open();
        waitUntilElementIsClickable(driver, videoCardsPage.getElDellCta());
        videoCardsPage.getElDellCta().click();
        Thread.sleep(3000);
        videoCardsPage.checkDoesEveryTitleOfArticleContainDell();
    }
}
