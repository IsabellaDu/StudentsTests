package org.example.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.core.Browsers;
import org.example.utils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {
    private static final String BROWSER = System.getProperty("browser");
    private static WebDriver driver;

    public static WebDriver getDriver() {
        String browserType = BROWSER != null ? BROWSER : ConfigProvider.getBROWSER();
        return getDriver(Browsers.valueOf(browserType.toUpperCase()));
    }

    public static WebDriver getDriver(Browsers browser) {
        switch (browser) {
            case CHROME:
                return getChromeDriver();
            case SAFARI:
                return getSafariDriver();
            case FIREFOX:
                return getFirefoxDriver();
           /* case OPERA:
                return getOperaDriver();*/
            default:
                throw new IllegalArgumentException("Wrong browser was chosen");
        }
    }

    public static WebDriver getChromeDriver() {
        /*Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);*/

        if (driver == null) {
            WebDriverManager.chromedriver().clearDriverCache().setup();
            WebDriverManager.chromedriver().clearResolutionCache().setup();
            //WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriver getSafariDriver() {
        if (driver == null) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        return driver;
    }

    public static WebDriver getFirefoxDriver() {
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

    /*public static WebDriver getOperaDriver() {
        if (driver == null) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }
        return driver;
    }*/
}
