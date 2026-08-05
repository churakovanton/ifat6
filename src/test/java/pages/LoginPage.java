package pages;

import io.qameta.allure.Step;
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

    @Step("Открытие браузера")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Вход в личный кабинет логин: {user.login} пароль: {user.password}")
    public void login(User user) {
        driver.findElement(userName).sendKeys(user.getLogin());
        driver.findElement(password).sendKeys(user.getPassword());
        driver.findElement(loginBtn).click();
    }

    @Step("Проверяем что ошибка отобразилась")
    public boolean isDisplayError() {
        return driver.findElement(error).isDisplayed();
    }

    @Step("Проверяем текст сообщения ошибки")
    public String getTextError() {
        return driver.findElement(error).getText();
    }
}
