package cucumber.steps;

import org.example.core.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseUISteps {
    protected static final WebDriver driver = WebDriverFactory.getDriver();
}
