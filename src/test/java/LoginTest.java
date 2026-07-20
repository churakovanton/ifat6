import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest {

    @Test
    public void correct() {

        WebDriver browser = new FirefoxDriver();
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        browser.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("#login-button")).click();
        boolean displayed = browser.findElement(By.xpath("//button[@data-test='error-button']")).isDisplayed();
        browser.quit();

        assertFalse(displayed);
    }

    @Test
    public void incorret() {

        WebDriver browser = new FirefoxDriver();
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.cssSelector("#user-name")).sendKeys("sdfsdf");
        browser.findElement(By.cssSelector("#password")).sendKeys("dfdsfsdf");
        browser.findElement(By.cssSelector("#login-button")).click();
        boolean displayed = browser.findElement(By.xpath("//button[@data-test='error-button']")).isDisplayed();
        String errorText = browser.findElement(By.xpath("//h3[@data-test='error']")).getText();
        browser.quit();

        assertTrue(displayed);
        assertEquals(errorText, "Epic sadface: Username and password do not match any user in this service");
    }
}
