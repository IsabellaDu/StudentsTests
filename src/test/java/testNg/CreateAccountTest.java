package testNg;

import org.example.core.data.DataProviderMethods;
import org.example.pages.CreateAccountPage;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {
    @Test(dataProvider = "dataForCreateAccountTest", dataProviderClass = DataProviderMethods.class)
    public void canCreateAccount(String firstName, String lastName, String email, String password, String confirmPassword) {
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.open();
        createAccountPage.setFirstName(firstName);
        createAccountPage.setLastName(lastName);
        createAccountPage.setEmail(email);
        createAccountPage.setPassword(password);
        createAccountPage.setConfirmPassword(confirmPassword);
        createAccountPage.getElCreateAccountCta().click();

        createAccountPage.checkAllErrorFields(firstName);
    }
}
