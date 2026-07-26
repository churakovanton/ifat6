package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test
    public void correct() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productPage.isOpen());
        assertEquals(productPage.getTitle(), "Products");
    }

    @Test
    public void incorret() {

        loginPage.open();
        loginPage.login("sdfsdf", "dfdsfsdf");

        assertTrue(loginPage.isDisplayError());
        assertEquals(loginPage.getTextError(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void locked() {

        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        assertTrue(loginPage.isDisplayError());
        assertEquals(loginPage.getTextError(), "Epic sadface: Sorry, this user has been locked out.");

    }

    @Test
    public void extraLargeLogin() {
        loginPage.open();
        loginPage.login(
                "locked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_user",
                "secret_sauce");

        assertTrue(loginPage.isDisplayError());
        assertEquals(loginPage.getTextError(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void passwordIsNull() {
        loginPage.open();
        loginPage.login(
                "locked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_user",
                "NULL");

        assertTrue(loginPage.isDisplayError());
        assertEquals(loginPage.getTextError(),
                "Epic sadface: Username and password do not match any user in this service");
    }
}
