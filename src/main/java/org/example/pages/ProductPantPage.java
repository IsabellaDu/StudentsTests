package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.example.utils.WaitUtils.waitUntilElementIsClickable;
import static org.example.utils.WaitUtils.waitUntilElementIsVisible;

public class ProductPantPage extends BasePage {
    private final String PRODUCT_URL = "https://magento2-demo.magebit.com/cora-parachute-pant.html";

    @FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
    private WebElement elTitle;
    @Getter
    @FindBy(xpath = "//div[@class='product-options-wrapper']//div[@data-option-tooltip-value='28']")
    private WebElement elSize28Cta;

    @FindBy(xpath = "//div[@class='swatch-attribute color']//div[@class='swatch-attribute-options clearfix']//div")
    private List<WebElement> elsColorList;

    @FindBy(xpath = "//div[@id='super_attribute[93]-error']")
    private WebElement elColorErrorMessage;

    @Getter
    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    private WebElement elAddToCartCta;


    public ProductPantPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(PRODUCT_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(driver, elTitle);
    }

    /*public void setColor1(String color) {
        switch (color) {
            case "Black":
                wait
                elBlackColorCta.click();
            case "Blue":
                wait
                elBlueColorCta.click();
            case "White":
                wait
                elWhiteColorCta.click();
        }
    }*/

    public void setColor(String color) {
        waitUntilElementIsClickable(driver, elsColorList.get(0));
        for (WebElement elColorCta : elsColorList) {
            if (elColorCta.getAttribute("data-option-label").equalsIgnoreCase(color)) {
                elColorCta.click();
            }
        }
    }

    public void checkErrorMessageForColor(String color) {
       /* List<WebElement> elsColorList = new ArrayList<>();
        elsColorList.add(elBlackColorCta);
        elsColorList.add(elBlueColorCta);
        elsColorList.add(elWhiteColorCta);*/

        boolean isNoneMatchInList = elsColorList.stream().noneMatch(x -> x.getAttribute("data-option-label").equalsIgnoreCase(color));
        if (color.isEmpty() || isNoneMatchInList) {
            waitUntilElementIsVisible(driver, elColorErrorMessage);
            Assert.assertEquals(elColorErrorMessage.getText(), "This is a required field.", "expected error message doesn't match actual message");
        }
    }
}
