package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {

    final By userName = By.cssSelector("#user-name");
    final By password = By.cssSelector("#password");
    final By loginBtn = By.cssSelector("#login-button");
    final By error = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(User user) {
        driver.findElement(userName).sendKeys(user.getLogin());
        driver.findElement(password).sendKeys(user.getPassword());
        driver.findElement(loginBtn).click();
    }

    public boolean isDisplayError() {
        return driver.findElement(error).isDisplayed();
    }

    public String getTextError() {
        return driver.findElement(error).getText();
    }
}
