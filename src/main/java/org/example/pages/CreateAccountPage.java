package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.example.utils.WaitUtils.waitUntilElementIsVisible;

public class CreateAccountPage extends BasePage {
    @Getter
    private final String CREATE_ACCOUNT_URL = "https://magento2-demo.magebit.com/customer/account/create/";

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement elFirstNameInput;

    @FindBy(xpath = "//div[@id='firstname-error']")
    private WebElement elFirstnameError;
    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement elLastNameInput;
    @FindBy(xpath = "//div[@id='lastname-error']")
    private WebElement elLastnameError;
    @FindBy(xpath = "//input[@id='is_subscribed']")
    private WebElement elIsSubscribedCheckBox;

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement elEmailInput;

    @FindBy(xpath = "//div[@id='email_address-error']")
    private WebElement elEmailError;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement elPasswordInput;
    @FindBy(xpath = "//div[@id='password-error']")
    private WebElement elPasswordError;
    @FindBy(xpath = "//input[@id='password-confirmation']")
    private WebElement elPasswordConfirmationInput;
    @FindBy(xpath = "//div[@id='password-confirmation-error']")
    private WebElement elPasswordConfirmationError;
    @Getter
    @FindBy(xpath = "//button[@class='action submit primary']")
    private WebElement elCreateAccountCta;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(CREATE_ACCOUNT_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(driver, elFirstNameInput);
    }

    public void setFirstName(String firstName) {
        waitUntilElementIsVisible(driver, elFirstNameInput);
        elFirstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        waitUntilElementIsVisible(driver, elLastNameInput);
        elLastNameInput.sendKeys(lastName);
    }

    public void setEmail(String email) {
        waitUntilElementIsVisible(driver, elEmailInput);
        elEmailInput.sendKeys(email);
    }

    public void setPassword(String password) {
        waitUntilElementIsVisible(driver, elPasswordInput);
        elPasswordInput.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        waitUntilElementIsVisible(driver, elPasswordConfirmationInput);
        elPasswordConfirmationInput.sendKeys(confirmPassword);
    }

    public void checkFirstNameError(String firstName) {
        if (firstName.isEmpty()) {
            waitUntilElementIsVisible(driver, elFirstnameError);
            Assert.assertEquals(elFirstnameError.getText(), "This is a required field.",
                    "expected firstname error message doesn't match actual message");
        }
    }

    public void checkAllErrorFields(String firstName) {
        checkFirstNameError(firstName);
    }
}
