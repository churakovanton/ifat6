package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static final String BASE_URL = "https://saucedemo.com";
    private final By pageName = By.cssSelector("[data-test='title']");
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver webdriver) {
        this.driver = webdriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public boolean isOpen() {
        return driver.findElement(pageName).isDisplayed();
    }
}
