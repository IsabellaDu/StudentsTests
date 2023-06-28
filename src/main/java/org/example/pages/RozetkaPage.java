package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.utils.WaitUtils.waitUntilElementIsVisible;

public class RozetkaPage extends BasePage {
    private final String ROZETKA_PAGE_URL = "https://rozetka.com.ua/";
    @Getter
    @FindBy(xpath = "//div[@class='header-layout']//ul[@class='header-actions']//li[@class='header-actions__item header-actions__item--user']//button")
    private WebElement elLogInCta;
    @Getter
    @FindBy(xpath = "//div[@class='form__row auth-modal__form-bottom']//button[@class='auth-modal__register-link button button--link ng-star-inserted']")
    private WebElement elSignInCta;

    @FindBy(xpath = "//form[@class='auth-modal__form ng-pristine ng-invalid ng-touched']//input[@id='registerUserName']")
    private WebElement elFirstNameInput;
    @FindBy(xpath = "//form[@class='auth-modal__form ng-pristine ng-invalid ng-touched']//input[@id='registerUserSurname']")
    private WebElement elSecondNameInput;

    @FindBy(xpath = "//form[@class='auth-modal__form ng-pristine ng-invalid ng-touched']//input[@id='registerUserPhone']")
    private WebElement elPhoneNumberInput;

    @FindBy(xpath = "//form[@class='auth-modal__form ng-pristine ng-invalid ng-touched']//input[@id='registerUserEmail']")
    private WebElement elEmailInput;

    @FindBy(xpath = "//form[@class='auth-modal__form ng-pristine ng-invalid ng-touched']//input[@id='registerUserPassword']")
    private WebElement elPasswordInput;


    public RozetkaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(ROZETKA_PAGE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(driver, elLogInCta);
    }
}
