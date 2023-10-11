package cucumber.steps;

import io.cucumber.java.AfterAll;

public class Hooks extends BaseUISteps {
    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

}
