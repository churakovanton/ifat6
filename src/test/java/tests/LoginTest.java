package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import utils.AllureUtils;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;
import static user.UserFactory.withLockedAdminPermission;

@Epic("Интернет-магазин")
@Feature("Авторизация")
@Owner("Антон Чураков my@email.com")
public class LoginTest extends BaseTest {

    @Story("Удачная авторизация")
    @Test(description = "Проверка корректной авторизации", priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("ifat6")
    @Issue("ifat6")
    public void validLogin() {
        loginPage.open();
        loginPage.login(withAdminPermission());

        AllureUtils.takeScreenshot(driver);
        assertTrue(productPage.isOpen());
        assertEquals(productPage.getTitle(), "Products",
                "Name of the page doesn't correspond to the expected");
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {new User("Standard_user", "secret_sauce"),
                        "Epic sadface: Username and password do not match any user in this service"},
                {withLockedAdminPermission(),
                        "Epic sadface: Sorry, this user has been locked out."},
                {new User("", "secret_sauce"), "Epic sadface: Username is required"},
                {new User("standard_user", ""), "Epic sadface: Password is required"}
        };
    }

    @Story("Неудачная авторизация")
    @Test(description = "Проверка некорректной авторизации", priority = 2, invocationCount = 1, dataProvider = "loginData")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("ifat6")
    @Issue("ifat6")
    public void invalidLogin(User user, String errorMsg) {
        loginPage.open();
        loginPage.login(user);
        assertTrue(loginPage.isDisplayError());
        assertEquals(loginPage.getTextError(), errorMsg);
    }
}
