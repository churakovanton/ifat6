package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    final By userName = By.cssSelector("#user-name");
    final By password = By.cssSelector("#password");
    final By loginBtn = By.cssSelector("#login-button");
    final By errorBtn = By.xpath("//button[@data-test='error-button']");
    final By errorText = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String login, String pass) {

        driver.findElement(userName).sendKeys(login);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean isDisplayError() {
        return driver.findElement(errorBtn).isDisplayed();
    }

    public String getTextError() {
        return driver.findElement(errorText).getText();
    }
}
