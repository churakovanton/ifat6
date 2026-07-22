package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    final By userName = By.cssSelector("#user-name");
    final By password = By.cssSelector("#password");
    final By loginBtn = By.cssSelector("#login-button");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://saucedemo.com");
    }

    public void login(String login, String pass) {

        driver.findElement(userName).sendKeys(login);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}
