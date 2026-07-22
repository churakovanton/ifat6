package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public void correct() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        String header = driver.findElement(By.xpath("//*[@data-test='title']")).getText();

        assertEquals(header, "Products");
    }

    @Test
    public void incorret() {

        loginPage.open();
        loginPage.login("sdfsdf", "dfdsfsdf");

        boolean displayed = driver.findElement(By.xpath("//button[@data-test='error-button']")).isDisplayed();
        String errorText = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();

        assertTrue(displayed);
        assertEquals(errorText, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void locked() {

        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        boolean displayed = driver.findElement(By.xpath("//button[@data-test='error-button']")).isDisplayed();
        String errorText = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();

        assertTrue(displayed);
        assertEquals(errorText, "Epic sadface: Sorry, this user has been locked out.");

    }

    @Test
    public void extraLargeLogin() {
        loginPage.open();
        loginPage.login(
                "locked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_user",
                "secret_sauce");

        boolean displayed = driver.findElement(By.xpath("//button[@data-test='error-button']")).isDisplayed();
        String errorText = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();

        assertTrue(displayed);
        assertEquals(errorText, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void passwordIsNull() {
        loginPage.open();
        loginPage.login(
                "locked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_userlocked_out_user",
                "NULL");

        boolean displayed = driver.findElement(By.xpath("//button[@data-test='error-button']")).isDisplayed();
        String errorText = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();

        assertTrue(displayed);
        assertEquals(errorText, "Epic sadface: Username and password do not match any user in this service");
    }
}
