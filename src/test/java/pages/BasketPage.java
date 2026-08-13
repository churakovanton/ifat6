package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {

    private final By firstName = By.cssSelector(DATA_TEST_PATTERN.formatted("firstName"));
    private final By lastName = By.cssSelector(DATA_TEST_PATTERN.formatted("lastName"));
    private final By postalCode = By.cssSelector(DATA_TEST_PATTERN.formatted("postalCode"));
    private final By continueButton = By.cssSelector(DATA_TEST_PATTERN.formatted("continue"));
    private final By cancelButton = By.cssSelector(DATA_TEST_PATTERN.formatted("cancel"));

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполняем данные покупателя")
    public void fillCustomerInfo(
            String firstNameValue,
            String lastNameValue,
            String postalCodeValue) {

        driver.findElement(firstName).sendKeys(firstNameValue);
        driver.findElement(lastName).sendKeys(lastNameValue);
        driver.findElement(postalCode).sendKeys(postalCodeValue);
    }

    @Step("Переход для проверки заказа")
    public void clickContinueCheckOrder() {
        driver.findElement(continueButton).click();
    }
}
