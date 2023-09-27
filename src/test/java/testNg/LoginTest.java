package testNg;

import org.example.core.data.DataProviderMethods;
import org.example.listeners.RetryListener;
import org.example.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "dataForLoginTest", dataProviderClass = DataProviderMethods.class,
            retryAnalyzer = RetryListener.class)
    public void canLogin(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.getElSignInCta().click();
        loginPage.checkErrorFields();
    }
}
