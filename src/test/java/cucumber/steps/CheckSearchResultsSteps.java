package cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.CoolBlueHomePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.utils.WaitUtils.waitUntilElementIsVisible;

public class CheckSearchResultsSteps extends BaseUISteps {
    CoolBlueHomePage homePage = new CoolBlueHomePage(driver);

    @Given("User wrote incorrect request down: {}")
    @Test
    public void writeSearchRequestDown(String userRequest) {
        homePage.open();
        homePage.getElSearchItemInput().sendKeys(userRequest, Keys.ENTER);
    }

    @Then("User should be able to see try-again message")
    @Test(dependsOnMethods = {"writeSearchRequestDown"})
    public void checkMessageIsDisplayed() {
        waitUntilElementIsVisible(driver, homePage.getElTryAgainText());
        Assert.assertEquals(homePage.getElTryAgainText().getText(),
                "Try again with a new search term.",
                "expected text doesn't match actual text");
    }


}
